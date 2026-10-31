package problem1;



public interface Mappable {
    final String JSON_PROPERTY = """
            "properties":{%s}""";

    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJSON(){
        return String.format("""
                "type": "%s", "label": "%s", "marker": "%s\"""", getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        System.out.printf((JSON_PROPERTY) + "%n", mappable.toJSON());
    }
}
