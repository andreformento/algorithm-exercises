package com.formento.algorithmexercises.pointinrectangle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.template.RegionTemplate;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import java.util.Collection;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = {"pretty", "html:target/cucumber"},
    features = "classpath:cucumber"
)
public class PointInsideRegionTest {

    @BeforeClass
    public static void initClass() {
        FixtureFactoryLoader.loadTemplates("com.formento.algorithmexercises.pointinrectangle.template");
    }


    /*
    P = (5,2) -> [F]
    P = (0,0) -> [A]
    P = (6,6) -> []
    P = (6,5) -> [E]
    P = (3,1) -> [D,F]
    P = (1,4) -> [B,C]
    P = (4,3) -> [D,E,F]
    P = (2,3) -> [A,B,C,D]
    P = (3,3) -> [C,D,E,F]
    * */

    private Region region;
    private Point point;
    private Collection<Rectangle> rectanglesByPoint;

    @Test
    public void shouldDoNothing() {
    }

    @Given("^a valid region$")
    public void given_a_valid_region() {
        this.region = Fixture.from(Region.class).gimme(RegionTemplate.VALID);
    }

    @And("^a point \\((\\d+),[\\w\\s]?(\\d+)\\)$")
    public void and_a_point(final Integer x, final Integer y) {
        this.point = new Point(x, y);
    }

    @When("^get rectangles by point$")
    public void when_get_rectangles_by_point() {
        rectanglesByPoint = region.getRectanglesByPoint(point);
    }

    @Then("^should be exist exactly (\\d+) rectangules$")
    public void should_be_exist_exactly_n_rectangules(final Integer quantityOfRectangles) {
        assertThat(rectanglesByPoint, is(notNullValue()));
        assertThat(rectanglesByPoint.size(), is(equalTo(quantityOfRectangles)));
    }

    @And("^should have this rectangules:$")
    public void should_have_this_rectangules(final List<String> rectangules) {
        System.out.println(rectangules);
    }

}
