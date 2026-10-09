public abstract class CampusPlace {
    private String name;

    public CampusPlace(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("地点名称不能为空");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public abstract String getType();
}
