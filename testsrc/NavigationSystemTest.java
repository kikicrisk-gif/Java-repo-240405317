import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationSystemTest {
    private NavigationSystem system;
    private CampusPlace gate;
    private CampusPlace building;

    @BeforeEach
    void setUp() {
        system = new NavigationSystem();
        gate = new Gate("正门");
        building = new Building("教学楼");
    }

    @Test
    void walkModeReturnsRoute() {
        String result = system.navigate(gate, building, "walk");
        assertTrue(result.contains("正门"));
        assertTrue(result.contains("教学楼"));
        assertTrue(result.contains("步行"));
    }

    @Test
    void bikeModeReturnsRoute() {
        String result = system.navigate(gate, building, "bike");
        assertTrue(result.contains("骑行"));
    }

    @Test
    void nullPlaceReturnsError() {
        assertEquals("输入错误：起点和终点不能为空。", system.navigate(null, building, "walk"));
    }

    @Test
    void sameStartAndEndReturnsError() {
        assertEquals("输入错误：起点和终点不能相同。", system.navigate(gate, gate, "walk"));
    }

    @Test
    void blankModeReturnsError() {
        assertEquals("输入错误：导航方式不能为空。", system.navigate(gate, building, " "));
    }

    @Test
    void unknownModeReturnsError() {
        assertEquals("输入错误：仅支持 walk（步行）或 bike（骑行）。",
                system.navigate(gate, building, "fly"));
    }

    @Test
    void blankPlaceNameIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Gate(" "));
    }
}
