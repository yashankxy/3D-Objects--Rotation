package Assignment;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

public class Mesh extends GraphicalObject{
    /**
     * OBJ format
     * The OBJ files to be considered consist of two consecutive sets of lines: the first set (lines starting with
     * a “v”) represents the unique vertices contained in the mesh and the second set (lines starting with an
     * “f”) represents the faces of the mesh. For example, the mesh below contains two polygons: the first
     * includes the vertices defined at lines 1, 2, and 3 and the second includes the vertices defined at lines
     * 2, 3, and 4.
     *
     *      v 5.1 1.2 0.3
     *      v 4.9 1.5 0.3
     *      v 3.8 1.4 0.5
     *      v 4.1 1.6 0.6
     *      f 1 2 3
     *      f 2 3 4
     *PLY format
     * The PLY format is similar to OBJ except for the following:
     *      - It has a header that specifies different aspects including the number of vertices and the
     *        number of faces. You can assume that the highlighted parts are fixed.
     *      - The lines representing the vertices do not start with a “v”.
     *      - The lines representing the faces do not start with an “f”. Instead, they start with the number
     *        of vertices included in the corresponding face.
     *      - Vertex indexing starts at 0 instead of 1. That is, the first line containing a vertex is labelled 0
     *
     *      ply
     *      format ascii 1.0
     *      element vertex 4
     *      property float32 x
     *      property float32 y
     *      property float32 z
     *      element face 2
     *      property list uint8 int32 vertex_indices
     *      end_header
     *      5.1 1.2 0.3
     *      4.9 1.5 0.3
     *      3.8 1.4 0.5
     *      4.1 1.6 0.6
     *      3 0 1 2
     *      3 1 2 3
     *
     */
    HashSet<Polygon> polygons;
    MeshReader reader;
    MeshWriter writer;

    // getters and setters
    void setReader(MeshReader reader){
        this.reader = reader;
    }
    void setWriter(MeshWriter writer){
        this.writer = writer;
    }


    // Methods
    void readFromFile(File x) throws Exception {
         this.polygons = reader.read(x.getName());
    }
    void writeToFile(File x) throws Exception{
        writer.write(x.getName(),this.polygons);
    }



    @Override
    void transform(double[][] transformedMatrix) {
        for (Polygon p : polygons ) {
            p.transform(transformedMatrix);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesh mesh = (Mesh) o;
        int size = polygons.size();
        boolean b = Objects.equals(polygons, mesh.polygons);
        int i =0;
        for (Polygon p: polygons){
            for (Polygon q: mesh.polygons){
                if(p.equals(q)){
                    i++;
                    break;
                }
            }
        }
        return i==size;
//        return b && Objects.equals(reader, mesh.reader) && Objects.equals(writer, mesh.writer);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for(Polygon p: polygons){
            hash = p.hashCode();
        }
        return (int) 3*hash;
    }
}

