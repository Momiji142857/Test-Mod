package vanilla.expansion.content;

import arc.graphics.Color;
import arc.util.Time;
import mindustry.content.StatusEffects;
import mindustry.type.Weather;
import mindustry.type.weather.ParticleWeather;
import mindustry.type.weather.RainWeather;
import mindustry.world.meta.Attribute;

public class VeWeathers {
    public static Weather
            massiveWind, storm, redSandstorm,
                    zentackWeather;

    public static void load() {

        massiveWind = new ParticleWeather("massive-wind") {{
            particleRegion = "circle-small";
            color = Color.valueOf("c7e5ff");
            noiseColor = Color.valueOf("938c9c");
            yspeed = 0f;
            xspeed = 3f;
            sizeMin = 1f;
            sizeMax = 5f;
            density = 1000f;
            minAlpha = 0.01f;
            maxAlpha = 0.1f;
            force = 0.25f;
            baseSpeed = 15f;
            drawNoise = true;
            useWindVector = true;
            duration = 3f * Time.toMinutes;
            attrs.set(Attribute.heat, -0.3f);
            attrs.set(Attribute.light, -0.1f);
            attrs.set(Attribute.steam, 4);
            sound = VeSounds.get("si2Wind");
            soundVol = 0.8f;
            status = VeStatusEffects.blown;
            statusGround = false;
        }};

        storm = new RainWeather("storm") {{
            yspeed = 9f;
            xspeed = 6f;
            padding = 24f;
            density = 720f;
            stroke = 1f;
            sizeMin = 16f;
            sizeMax = 80f;
            opacityMultiplier = 0.7f;
            attrs.set(Attribute.water, 1);
            attrs.set(Attribute.light, -0.6f);
            attrs.set(Attribute.steam, 2);
            sound = VeSounds.get("si2Rain");
            soundVol = 1.2f;
            status = StatusEffects.wet;
        }};

        redSandstorm = new ParticleWeather("red-sandstorm") {{
            particleRegion = "circle-small";
            color = noiseColor = Color.valueOf("ba754e");
            yspeed = 0f;
            xspeed = 2f;
            sizeMin = 0.1f;
            sizeMax = 4f;
            density = 3000f;
            minAlpha = 0.7f;
            maxAlpha = 1f;
            force = 0.4f;
            baseSpeed = 10f;
            drawNoise = true;
            useWindVector = true;
            duration = 10f * Time.toMinutes;
            opacityMultiplier = 0.2f;
            attrs.set(Attribute.light, -0.5f);
            attrs.set(Attribute.sand, 7);
            attrs.set(Attribute.steam, 3);
            sound = VeSounds.get("utySandstorm");
            soundVol = 0.5f;
            statusGround = false;
        }};

        zentackWeather = new ParticleWeather("zentack-weather") {{
            particleRegion = "ve-watermelon-effect";
            color = Color.valueOf("ffffff"); // ff776b
            noiseColor = Color.valueOf("edfde2"); // edfde2
            yspeed = 0f;
            xspeed = -8f;
            sizeMin = 5f;
            sizeMax = 40f;
            density = 2000f;
            minAlpha = 0.05f;
            maxAlpha = 0.5f;
            force = 0f;
            noiseScale = 8000f;
            baseSpeed = 5f;
            drawNoise = false;
            useWindVector = false;
            randomParticleRotation = true;
            // noise = "noiseAlphaZentack";
            duration = 3f * Time.toMinutes;
            sound = VeSounds.get("si2Wind");
            soundVol = 0.2f;
            statusGround = false;
        }};

        /*
        weather = new ParticleWeather("") {{
            // = new ParticleWeather("") {{
            particleRegion = ""; // "circle-shadow"
            color = Color.valueOf("");
            noiseColor = Color.valueOf("");
            yspeed = f; // -2f
            xspeed = f; // 0.25f
            padding = f; // 16f
            sizeMin = f; // 2.4f
            sizeMax = f; // 12f
            density = f; // 1200f
            minAlpha = f; // 1f
            maxAlpha = f; // 1f
            force = f; // 0f
            noiseScale = f; // 2000f
            baseSpeed = f; // 6.1f
            sinSclMin = f; // 30f
            sinSclMax = f; // 80f
            sinMagMin = f; // 1f
            sinMagMax = f; // 7f
            drawNoise = ; // false
            drawParticles = ; // true
            useWindVector = ; // false
            randomParticleRotation = ; // false
            noiseLayers = ; // 1
            noiseLayerSpeedM = f; // 1.1f
            noiseLayerAlphaM = f; // 0.8f
            noiseLayerSclM = f; // 0.99f
            noiseLayerColorM = f; // 1f
            noisePath = "";
            noise = ;

            // = new RainWeather() {{
            yspeed = f; // 5f
            xspeed = f; // 1.5f
            padding = f; // 16f
            density = f; // 1200f
            stroke = f; // 0.75f
            sizeMin = f; // 8f
            sizeMax = f; // 40f
            splashTimeScale = f; // 22f
            liquid = Liquids.; // water
            splashes = ; // new TextureRegion[12];
            color = Color.valueOf("");

            boundMax = f;
            duration = f; // 10f * Time.toMinutes
            opacityMultiplier = f; // 1f;
            attrs.set(Attribute., );
            sound = Sounds.; // none
            soundVol = f; // 0.1f
            soundVolMin = f; // 0f
            soundVolOscMag = f; // 0f
            soundVolOscScl = f; // 20f
            hidden = ; // false
            status = StatusEffects.; // none
            statusDuration = f; // 60f * 2
            statusAir = ; // true
            statusGround = ; // true
        }};
         */

    }
}
