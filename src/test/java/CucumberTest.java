import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import ru.tests.BeforeAfterSetup;

@RunWith(Cucumber.class) //inherit Cucumber class from io.cucumber.junit.Cucumber -> "<artifactId>cucumber-java</artifactId>"
@CucumberOptions(monochrome = true,
        features = {"src/test/java/ru/tests/features"},
        glue = {"com.main"},
        tags = {"@test"}
)

public class CucumberTest {

    public static void beforeSetup(){
        new BeforeAfterSetup().setUp();
    }

    public static void afterClassAction(){
        new BeforeAfterSetup().tearDown();
    }
}