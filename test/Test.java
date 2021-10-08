import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

class Test {
    @Test
    public void check1() {
        Task1 t = new Task1();
        final List<String> list = Arrays.asList("1", "2", "3");
        assertEquals("invalid array", t.arrayChallanger(list));
    }

    @Test
    public void check2() {
        Task1 t = new Task1();
        final List<String> list = Arrays.asList("1", "2", "2", "1", "3", "3");
        assertEquals("3, 3", t.arrayChallanger(list));
    }

    @Test
    public void check3() {
        Task1 t = new Task1();
        final List<String> list = Arrays.asList("5", "4", "6", "7", "7", "6", "4", "5");
        assertEquals("yes", t.arrayChallanger(list));
    }
}