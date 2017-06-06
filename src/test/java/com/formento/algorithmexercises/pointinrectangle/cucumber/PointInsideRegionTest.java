package com.formento.algorithmexercises.pointinrectangle.cucumber;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formento.algorithmexercises.pointinrectangle.Point;
import com.formento.algorithmexercises.pointinrectangle.Rectangle;
import com.formento.algorithmexercises.pointinrectangle.Region;
import com.google.common.collect.ImmutableList;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class PointInsideRegionTest {

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

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Region region;
    private Point point;
    private Collection<Rectangle> rectanglesByPoint;

    private List<Rectangle> rectanglesReader(final DataTable dataTable) {
        final ImmutableList.Builder<Rectangle> rectanglesBuilder = ImmutableList.builder();
        for (List<String> fields : dataTable.raw()) {
            rectanglesBuilder.add(new Rectangle(
                new Point(Integer.valueOf(fields.get(0)), Integer.valueOf(fields.get(1))),
                new Point(Integer.valueOf(fields.get(2)), Integer.valueOf(fields.get(3)))
            ));
        }
        return rectanglesBuilder.build();
    }

    @Given("^the region with this rectangles:$")
    public void given_a_valid_region(final DataTable dataTable) throws IOException {
        this.region = new Region.Builder().addRectangles(rectanglesReader(dataTable)).build();
    }

    @And("^a point \\((\\d+),[\\w\\s]?(\\d+)\\)$")
    public void and_a_point(final Integer x, final Integer y) {
        this.point = new Point(x, y);
    }

    @When("^get rectangles by point$")
    public void when_get_rectangles_by_point() {
        rectanglesByPoint = region.getRectanglesByPoint(point);
    }

    @Then("^should be exist exactly (\\d+) rectangles$")
    public void should_be_exist_exactly_n_rectangles(final Integer quantityOfRectangles) {
        assertThat(rectanglesByPoint, is(notNullValue()));
        assertThat(rectanglesByPoint.size(), is(equalTo(quantityOfRectangles)));
    }

    @And("^should have this rectangles:$")
    public void should_have_this_rectangles(final DataTable dataTable) {
        System.out.println(rectanglesReader(dataTable));
    }

}
