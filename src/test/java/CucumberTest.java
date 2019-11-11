import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) //inherit Cucumber class from io.cucumber.junit.Cucumber -> "<artifactId>cucumber-java</artifactId>"
@CucumberOptions(monochrome = true,
        features = {"src/test/java/ru/tests/features"},
        glue = {"com.main"},
        tags = {"@sale"}
)

// class name should end with the word "Test" otherwise it would be launched!
public class CucumberTest {

}