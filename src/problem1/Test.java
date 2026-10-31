package problem1;

public class Test {
    public static void main(String[] args) {
        Mappable.mapIt(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        Mappable.mapIt(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
    }
}
