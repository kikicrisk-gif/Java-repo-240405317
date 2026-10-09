public class Building extends CampusPlace {
    public Building(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "建筑";
    }
}
