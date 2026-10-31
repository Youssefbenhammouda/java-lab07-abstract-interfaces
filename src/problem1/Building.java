package problem1;

public class Building implements  Mappable{
    private String name;
    private UsageType type;

    public Building(String name, UsageType type){
        this.name = name;
        this.type = type;

    }
    @Override
    public String getLabel() {
        return name + " (" + type + ")";

    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {

        return switch (type){
            default -> Color.RED + " " + PointMarkers.STAR;
        };


    }
    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
        , "name": "%s", "usage": "%s\"""".formatted(name, type.name());
    }
}
