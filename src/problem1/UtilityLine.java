package problem1;

public class UtilityLine implements Mappable{
    private String name;
    private UtilityType type;
    public UtilityLine(String name, UtilityType type){
        this.name = name;
        this.type = type;

    }
    @Override
    public String getLabel() {
            return name + " ("+type+")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }


    @Override
    public String getMarker() {

        return LineMarkers.DOTTED + " " + Color.GREEN;
    }
    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
        , "name": "%s", "usage": "%s\"""".formatted(name, type.name());
    }
}
