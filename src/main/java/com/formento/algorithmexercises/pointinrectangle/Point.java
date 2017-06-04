package com.formento.algorithmexercises.pointinrectangle;

import java.util.Comparator;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point implements Comparable<Point> {

    @NonNull
    private final Integer x;
    @NonNull
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

    @Override
    public int compareTo(Point other) {
        final int compare = Integer.compare(x, other.x);
        if (compare == 0) {
            return Integer.compare(y, other.y);
        }
        return compare;
    }

}
