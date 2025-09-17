import org.example.Hello;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloTest {
    @Test
    void testSayHelloWorld() {
        Hello hello = new Hello();
        assertEquals("Hello, World!", hello.sayHello("World"));
    }
}
