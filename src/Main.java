import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CampusPlace gate = new Gate("正门");
        CampusPlace building = new Building("教学楼");
        Scanner scanner = new Scanner(System.in);

        System.out.println("校园导航系统");
        System.out.println("地点：1. 正门  2. 教学楼");
        System.out.print("请输入起点编号：");
        String startChoice = readLine(scanner);
        System.out.print("请输入终点编号：");
        String endChoice = readLine(scanner);

        CampusPlace start = choosePlace(startChoice, gate, building);
        CampusPlace end = choosePlace(endChoice, gate, building);
        if (start == null || end == null) {
            System.out.println("输入错误：地点编号只能是 1 或 2。");
            return;
        }

        System.out.print("请输入导航方式（walk/步行 或 bike/骑行）：");
        String mode = readLine(scanner);
        NavigationSystem system = new NavigationSystem();
        String result = system.navigate(start, end, mode);
        System.out.println(result);
    }

    private static String readLine(Scanner scanner) {
        if (scanner.hasNextLine()) {
            return scanner.nextLine().trim();
        }
        return "";
    }

    private static CampusPlace choosePlace(String choice, CampusPlace gate, CampusPlace building) {
        if ("1".equals(choice)) {
            return gate;
        } else if ("2".equals(choice)) {
            return building;
        } else {
            return null;
        }
    }
}
