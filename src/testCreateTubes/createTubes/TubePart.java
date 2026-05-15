package testCreateTubes.createTubes;

public class TubePart extends StatefulRegionPart {
    public int tubeCount = 4;
    public PartProgress speedFunc = p -> 0f; // 占位，将被 createTubes 覆写
    public PartProgress layerProgress = p -> 0f;
    public PartProgress colorProgress = p -> 0.5f;

    public TubePart(String suffix) { super(suffix); }
    public TubePart() { super(); }
}
