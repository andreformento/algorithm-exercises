package com.formento.algorithmexercises.pointinrectangle;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Collection;
import java.util.Objects;
import lombok.Getter;

@Getter
public class Region {

    private final Collection<Rectangle> rectangles;

    private Region(final Collection<Rectangle> rectangles) {
        this.rectangles = ImmutableSortedSet.<Rectangle>naturalOrder().addAll(rectangles).build();
    }

    public static class Builder {

        private final ImmutableList.Builder<Rectangle> rectangles;

        public Builder() {
            this.rectangles = ImmutableList.builder();
        }

        public Builder addRectangle(final Rectangle... rectangle) {
            this.rectangles.add(rectangle);
            return this;
        }

        public Builder addRectangles(final Iterable<? extends Rectangle> rectangles) {
            this.rectangles.addAll(rectangles);
            return this;
        }

        public Region build() {
            return new Region(rectangles.build());
        }
    }

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
