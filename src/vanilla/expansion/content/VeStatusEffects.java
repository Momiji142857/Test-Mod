package vanilla.expansion.content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.effect.WrapEffect;
import mindustry.type.StatusEffect;

public class VeStatusEffects {
    public static StatusEffect
            blown, dusty, frozen,

            fusing, watermelon,
                    sodiumified, combusting,
                    coordinate, interrupted,

            sentryAlert, sentrySeen,
                    captured, plasmaStatus,

            pog,
                    charging, fungitronFast, suppressed,
                    dashing, drag, exhausted, killed, plasmaStatusOrange, thunderCharging, walking;

    public static void load() {

        blown = new StatusEffect("blown") {{
            healthMultiplier = 0.9f;
            dragMultiplier = 0f;
            transitionDamage = 20f;
            color = Color.valueOf("90dbff");
            init(() -> {
                opposite(StatusEffects.burning, StatusEffects.wet, StatusEffects.muddy, StatusEffects.tarred);
                affinity(StatusEffects.corroded, (unit, result, time) -> {
                    unit.damagePierce(20f);
                    result.set(StatusEffects.corroded, Math.min(time + result.time, 180.0F));
                });
            });
        }};

        dusty = new StatusEffect("dusty") {{
            reloadMultiplier = 0.75f;
            dragMultiplier = 1.1f;
            parentizeEffect = true;
            color = Color.valueOf("ba754e");
            effect = new ParticleEffect() {{
                colorFrom = colorTo = Color.valueOf("ba754e");
                particles = 1;
                length = 0f;
                sizeInterp = Interp.circleIn;
                sizeFrom = 0.5f;
                lifetime = 180f;
                rotWithParent = true;
            }};
            init(() -> {
                opposite(StatusEffects.wet, blown, walking);
            });
        }};

        frozen = new StatusEffect("frozen") {{
            healthMultiplier = 0.75f;
            speedMultiplier = 0.35f;
            reloadMultiplier = 1.2f;
            transitionDamage = 40f;
            color = Color.valueOf("adf7ff");
            effect = Fx.freezing;
            init(() -> {
                opposite(StatusEffects.burning, StatusEffects.melting, combusting);
                affinity(StatusEffects.blasted, (unit, result, time) -> {
                    unit.damagePierce(40f);
                });
            });
        }};

        fusing = new StatusEffect("fusing") {{
            speedMultiplier = 0.5f;
            dragMultiplier = 1.5f;
            transitionDamage = 60f;
            damage = 0.5f;
            effectChance = 0.5f;
            color = Color.valueOf("f17e10");
            effect = Fx.melting;
            init(() -> {
                affinity(StatusEffects.tarred, (unit, result, time) -> {
                    unit.damagePierce(100f);
                    result.set(StatusEffects.burning, Math.min(time + result.time, 300.0F));
                });
                affinity(sodiumified, (unit, result, time) -> {
                    unit.damagePierce(40f);
                    result.set(StatusEffects.burning, Math.min(time + result.time, 120.0F));
                });
                affinity(StatusEffects.blasted, (unit, result, time) -> {
                    unit.damagePierce(60f);
                });
                affinity(frozen, (unit, result, time) -> {
                    unit.damagePierce(0f);
                    Fx.smokeCloud.at(unit.x, unit.y);
                    result.set(dusty, 600.0F);
                });
                affinity(StatusEffects.freezing, (unit, result, time) -> {
                    unit.damagePierce(0f);
                    Fx.smokeCloud.at(unit.x, unit.y);
                    result.set(dusty, 600.0F);
                });
            });
        }};

        watermelon = new StatusEffect("watermelon") {{
            buildSpeedMultiplier = 0f;
            transitionDamage = 300f;
            damage = -1.25f;
            color = Color.valueOf("ff5555");
            /*
            applyEffect = new SoundEffect(Sounds.mcBurp, Fx.none) {{
                startDelay = 72;
                rotWithParent = true;
                followParent = true;
                maxVolume = 0.8f;
                minVolume = 0.8f;
            }};
             */
            init(() -> {
                opposite(StatusEffects.burning, StatusEffects.melting, StatusEffects.corroded, blown, combusting, suppressed);

                affinity(StatusEffects.freezing, (unit, result, time) -> unit.damagePierce(-50F));
                affinity(frozen, (unit, result, time) -> unit.damagePierce(-50.0F));
                affinity(sodiumified, (unit, result, time) -> {
                    unit.damagePierce(300f);
                    result.set(StatusEffects.burning, 300.0F);
                });
            });
        }};

        sodiumified = new StatusEffect("sodiumified") {{
            buildSpeedMultiplier = 0.25f;
            transitionDamage = 30f;
            permanent = false;
            reactive = true;
            color = Color.valueOf("d4e5ed");
            applyEffect = new ParticleEffect() {{
                colorFrom = colorTo = Color.valueOf("d4e5ed");
                particles = 1;
                length = 0F;
                sizeInterp = Interp.circleIn;
                sizeFrom = 0.5F;
                lifetime = 180F;
                rotWithParent = true;
            }};
            parentizeApplyEffect = true;
            init(() -> {
                opposite(StatusEffects.melting, StatusEffects.tarred);
                affinity(StatusEffects.burning, (unit, result, time) -> {
                    unit.damagePierce(30f);
                    Fx.blastExplosion.at(unit.x, unit.y);
                    result.set(StatusEffects.blasted, 60.0F);
                });
                affinity(StatusEffects.wet, (unit, result, time) -> {
                    unit.damagePierce(30f);
                    result.set(StatusEffects.burning, 300.0F);
                });
                affinity(StatusEffects.muddy, (unit, result, time) -> {
                    unit.damagePierce(10f);
                    result.set(StatusEffects.burning, 60.0F);
                });
                affinity(StatusEffects.corroded, (unit, result, time) -> {
                    unit.damagePierce(60f);
                    Fx.blastExplosion.at(unit.x, unit.y);
                    result.set(dusty, 300.0F);
                });
            });
        }};

        combusting = new StatusEffect("combusting") {{
            color = Color.valueOf("ffa665");
            transitionDamage = 240f;
            effect = Fx.burning;
            damage = 2.5f;
            effectChance = 1f;
            init(() -> {
                opposite(StatusEffects.freezing, StatusEffects.wet, frozen);
                affinity(StatusEffects.tarred, (unit, result, time) -> {
                    unit.damagePierce(120f);
                    result.set(combusting, Math.min(time + result.time, 360.0F));
                });
                affinity(StatusEffects.corroded, (unit, result, time) -> {
                    unit.damagePierce(40f);
                    result.set(combusting, Math.min(time + result.time, 60.0F));
                });
                affinity(sodiumified, (unit, result, time) -> {
                    unit.damagePierce(240f);
                    result.set(combusting, Math.min(time + result.time, 120.0F));
                });
            });
        }};

        coordinate = new StatusEffect("coordinate") {{
            buildSpeedMultiplier = 2.7f;
            effectChance = 0.01f;
            permanent = false;
            color = Color.valueOf("ffd37f");
            effect = new ParticleEffect() {{
                colorFrom = Color.valueOf("ffd37f");
                colorTo = Color.valueOf("ffd37f00");
                particles = 1;
                length = -1f;
                baseLength = 6f;
                interp = Interp.circleIn;
                sizeTo = 1f;
                spin = -3f;
                region = "ve-square-effect";
                lifetime = 90f;
            }};
            applyEffect = new WaveEffect() {{
                colorFrom = Color.valueOf("ffd37f");
                colorTo = Color.valueOf("ffd37f00");
                sides = 4;
                sizeFrom = 20;
                sizeTo = 18;
                strokeFrom = 1f;
                strokeTo = 1f;
                interp = Interp.circleOut;
                lifetime = 60f;
                followParent = true;
            }};
            applyExtend = true;
            parentizeApplyEffect = true;
            init(() -> {
                opposite(interrupted);
            });
        }};

        interrupted = new StatusEffect("interrupted") {{
            buildSpeedMultiplier = 0.3f;
            effectChance = 0.01f;
            permanent = false;
            color = Color.valueOf("f25555");
            effect = new ParticleEffect() {{
                colorFrom = Color.valueOf("f25555");
                colorTo = Color.valueOf("f25555").a(0f);
                particles = 1;
                length = 1f;
                baseLength = 5f;
                interp = Interp.circleOut;
                sizeTo = 1f;
                spin = 3f;
                region = "ve-square-effect";
                lifetime = 90f;
            }};
            applyEffect = new WaveEffect() {{
                colorFrom = Color.valueOf("f25555");
                colorTo = Color.valueOf("f25555").a(0f);
                sides = 4;
                sizeFrom = 18f;
                sizeTo = 20f;
                strokeFrom = 1f;
                strokeTo = 1f;
                interp = Interp.circleOut;
                lifetime = 60f;
                followParent = true;
            }};
            applyExtend = true;
            parentizeApplyEffect = true;
        }};

        sentryAlert = new StatusEffect("sentry-alert") {{
            speedMultiplier = 1.02f;
            color = Color.valueOf("f25555");
        }};

        sentrySeen = new StatusEffect("sentry-seen") {{
            speedMultiplier = 1.02f;
            color = Color.valueOf("ffa665");
            applyEffect = new WaveEffect() {{
                colorFrom = Color.valueOf("f25555");
                colorTo = Color.valueOf("f2555500");
                sides = 4;
                sizeFrom = 18;
                sizeTo = 20;
                strokeFrom = 1f;
                strokeTo = 1f;
                interp = Interp.circleOut;
                lifetime = 60f;
                followParent = true;
            }};
            parentizeApplyEffect = true;
        }};

        captured = new StatusEffect("captured") {{
            speedMultiplier = 0f;
            effectChance = 0.5f;
            parentizeEffect = true;
            color = Color.valueOf("00ffce");
            effect = new ParticleEffect() {{
                colorFrom = colorTo = Color.valueOf("00ffce");
                particles = 1;
                length = -1f;
                baseLength = 6f;
                interp = Interp.circleIn;
                sizeFrom = 3f;
                region = "ve-square-effect";
                lifetime = 3f;
            }};
            applyEffect = new WrapEffect(Fx.hitLaserBlast, Color.valueOf("00ffce"));
        }};

        plasmaStatus = new StatusEffect("plasma-status") {{
            speedMultiplier = 0.9f;
            buildSpeedMultiplier = 1.5f;
            transitionDamage = 50f;
            damage = 1f;
            effectChance = 0.5f;
            parentizeEffect = true;
            permanent = false;
            color = Color.valueOf("00ffce");
            effect = new ParticleEffect() {{
                colorFrom = colorTo = Color.valueOf("00ffce");
                particles = 1;
                length = -1f;
                baseLength = 6f;
                interp = Interp.circleIn;
                sizeFrom = 3f;
                region = "ve-square-effect";
                lifetime = 3f;
            }};
            applyEffect = new WrapEffect(Fx.hitLaserBlast, Color.valueOf("00ffce"));
            applyExtend = true;
            parentizeApplyEffect = false;
            init(() -> {
                opposite(StatusEffects.freezing, StatusEffects.wet, StatusEffects.muddy, frozen);
                affinity(StatusEffects.tarred, (unit, result, time) -> {
                    unit.damagePierce(50f);
                    result.set(StatusEffects.burning, Math.min(time + result.time, 300.0F));
                });
                affinity(StatusEffects.shocked, (unit, result, time) -> {
                    unit.damagePierce(30f);
                    result.set(StatusEffects.electrified, Math.min(time + result.time, 120.0F));
                });
                affinity(StatusEffects.corroded, (unit, result, time) -> {
                    unit.damagePierce(100);
                    result.set(StatusEffects.corroded, Math.min(time + result.time, 120.0F));
                });
                affinity(StatusEffects.sporeSlowed, (unit, result, time) -> {
                    unit.damagePierce(50f);
                    result.set(StatusEffects.burning, Math.min(time + result.time, 300.0F));
                });
            });
        }};

        pog = new StatusEffect("pog") {{
            damageMultiplier = 2f;
            healthMultiplier = 5f;
            speedMultiplier = 3f;
            reloadMultiplier = 10f;
            buildSpeedMultiplier = 3f;
            damage = -0.41666666666666667f;
            permanent = false;
            color = Color.valueOf("ffd37f");
            effect = Fx.hitBulletSmall;
            applyEffect = Fx.blastExplosion;
        }};

        charging = new StatusEffect("charging") {{
            damageMultiplier = 1.05f;
            transitionDamage = -25f;
            effectChance = 0.005f;
            permanent = false;
            color = Color.valueOf("ffa665");
            effect = new ParticleEffect() {{
                colorFrom = Color.valueOf("ffffff");
                colorTo = Color.valueOf("ffa665");
                particles = 3;
                line = true;
                strokeFrom = 3f;
                lenFrom = 10f;
                lenTo = 0f;
                lifetime = 10f;
            }};
            init(() -> {
                opposite(StatusEffects.sapped, StatusEffects.electrified, suppressed);
            });
        }};

        fungitronFast = new StatusEffect("fungitron-fast") {{
            damageMultiplier = 2f;
            speedMultiplier = 2f;
            permanent = false;
            show = false;
            color = Color.valueOf("7457ce");
        }};

        suppressed = new StatusEffect("suppressed") {{
            damageMultiplier = 0.9f;
            reloadMultiplier = 0.6f;
            buildSpeedMultiplier = 0.5f;
            effectChance = 0.01f;
            permanent = false;
            color = Color.valueOf("bf92f9");
            effect = new ParticleEffect() {{
                colorFrom = Color.valueOf("bf92f9");
                colorTo = Color.valueOf("bf92f900");
                particles = 1;
                length = -1f;
                baseLength = 6f;
                interp = Interp.circleIn;
                sizeTo = 1f;
                lifetime = 90f;
            }};
        }};

        dashing = new StatusEffect("dashing") {{
            speedMultiplier = 8f;
            dragMultiplier = 0.5f;
            show = false;
            color = Color.valueOf("777777");
        }};

        drag = new StatusEffect("drag") {{
            speedMultiplier = 0f;
            buildSpeedMultiplier = 0f;
            dragMultiplier = 10000f;
            permanent = false;
            color = Color.valueOf("777777");
        }};

        exhausted = new StatusEffect("exhausted") {{
            damageMultiplier = 0f;
            buildSpeedMultiplier = 0.01f;
            permanent = false;
            color = Color.valueOf("aaaaaa");
            effect = Fx.smoke;
            applyEffect = Fx.mineHuge;
        }};

        killed = new StatusEffect("killed") {{
            damage = 2147483247f;
            effectChance = 0f;
            show = false;
            color = Color.valueOf("f25555");
        }};

        plasmaStatusOrange = new StatusEffect("plasma-status-orange") {{
            speedMultiplier = 0.9f;
            buildSpeedMultiplier = 1.5f;
            transitionDamage = 100f;
            damage = 1f;
            effectChance = 0.5f;
            parentizeEffect = true;
            permanent = false;
            show = false;
            color = Color.valueOf("ffa665");
            effect = new ParticleEffect() {{
                colorFrom = colorTo = Color.valueOf("ffa665");
                particles = 1;
                length = -1f;
                baseLength = 6f;
                interp = Interp.circleIn;
                sizeFrom = 3f;
                region = "ve-square-effect";
                lifetime = 3f;
            }};
            applyEffect = new WrapEffect(Fx.hitLaserBlast, Color.valueOf("ffa665"));
            applyExtend = true;
            parentizeApplyEffect = false;
            init(() -> {
                opposite(StatusEffects.freezing, StatusEffects.wet, StatusEffects.muddy, frozen);
                affinity(StatusEffects.tarred, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                });
                affinity(StatusEffects.shocked, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                });
                affinity(StatusEffects.corroded, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                });
                affinity(StatusEffects.sporeSlowed, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                });
            });
        }};

        thunderCharging = new StatusEffect("thunder-charging") {{
            healthMultiplier = 0.6f;
            speedMultiplier = 0f;
            reloadMultiplier = 2.5f;
            dragMultiplier = 2f;
            effectChance = 0.3f;
            show = false;
            color = Color.valueOf("00ffce");
            effect = new ParticleEffect() {{
                colorFrom = Color.valueOf("ffffff");
                colorTo = Color.valueOf("00ffce");
                particles = 4;
                line = true;
                strokeFrom = 3f;
                lenFrom = 10f;
                lenTo = 0f;
                lifetime = 10f;
            }};
        }};

        walking = new StatusEffect("walking") {{
            dragMultiplier = 6f;
            show = false;
            color = Color.valueOf("777777");
        }};

    }
}
