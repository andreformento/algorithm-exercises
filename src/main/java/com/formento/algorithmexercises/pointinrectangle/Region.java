package com.formento.algorithmexercises.pointinrectangle;

import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Region {

    private final List<Rectangle> rectangles;

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Region)) {
            return false;
        }
        Region region = (Region) o;
        return Objects.equals(rectangles, region.rectangles);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(rectangles);
    }

}
