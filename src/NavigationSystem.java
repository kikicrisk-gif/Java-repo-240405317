public class NavigationSystem {
    public String navigate(CampusPlace start, CampusPlace end, String mode) {
        if (start == null || end == null) {
            return "输入错误：起点和终点不能为空。";
        } else if (start.getName().equals(end.getName())) {
            return "输入错误：起点和终点不能相同。";
        } else if (mode == null || mode.trim().isEmpty()) {
            return "输入错误：导航方式不能为空。";
        } else {
            String selectedMode = mode.trim();
            String route = "从" + start.getType() + start.getName()
                    + "到" + end.getType() + end.getName();

            if ("walk".equalsIgnoreCase(selectedMode) || "步行".equals(selectedMode)) {
                return route + "：请步行沿校园主路前往。";
            } else if ("bike".equalsIgnoreCase(selectedMode) || "骑行".equals(selectedMode)) {
                return route + "：请骑行沿校园骑行道前往。";
            } else {
                return "输入错误：仅支持 walk（步行）或 bike（骑行）。";
            }
        }
    }
}
