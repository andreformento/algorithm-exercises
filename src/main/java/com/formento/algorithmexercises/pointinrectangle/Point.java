package com.formento.algorithmexercises.pointinrectangle;

import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point {

    private final Integer x;
    private final Integer y;

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
            Objects.equals(y, point.y);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(x, y);
    }

}
