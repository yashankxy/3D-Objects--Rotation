package Assignment;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Polygon extends GraphicalObject{

    LinkedHashSet<Vertex> vertices;

    public Polygon(LinkedHashSet<Vertex> vertices) {
        this.vertices = vertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(vertices, polygon.vertices);
    }

    @Override
    public int hashCode() {
        int hash=0;
        for(Vertex v: vertices){
            hash += v.hashCode();
        }
        return (int)3*hash;

    }

    @Override
    void transform(double[][] transformedMatrix) {
        for (Vertex v: vertices){
            v.transform(transformedMatrix);
        }
    }
}
