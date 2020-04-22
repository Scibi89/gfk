import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    features = {"src/test/features/NYTimes.feature"},
    plugin = {"json:NYTimes/target/cucumber-parallel/json/1.json"},
    monochrome = true,
    glue = {"com.gfk"})
public class TestRunner {

}
