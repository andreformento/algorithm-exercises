package com.formento.algorithmexercises.pointinrectangle;

import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Rectangle {

    private final Point leftBottom;
    private final Point rightTop;

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftBottom, rectangle.leftBottom) &&
            Objects.equals(rightTop, rectangle.rightTop);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(leftBottom, rightTop);
    }
}
