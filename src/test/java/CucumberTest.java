import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = {"src/test/java/ru/tests/features"},
        glue = {"com.main"},
        tags = {"@addtoppings"}
)

public class CucumberTest {

}