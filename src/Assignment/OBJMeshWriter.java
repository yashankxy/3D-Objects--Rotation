package Assignment;

import java.awt.*;
import java.io.*;
import java.util.*;

public class OBJMeshWriter implements MeshWriter{
    @Override
    public void write(String fileName, HashSet<Polygon> polygons) throws Exception {
        ArrayList<Double[]> arrayOfVertex = new ArrayList<>();                          //  [[ 5.1 1.2 0.3], [ 4.9 1.5 0.3], [3.8 1.4 0.5], [4.1 1.6 0.6] ]
        ArrayList<Integer[]> arrayOfFaces = new ArrayList<Integer[]>();                 //  [[1 2 3] [2 3 4]]

        try {

        // save all vertices in arrayOfVertex
        Set<Integer> sc1 = new HashSet<>();
        for (Polygon p : polygons){
            for (Vertex v : p.vertices) {
                Double[] vertex = {v.x, v.y, v.z};

                if(0 == arrayOfVertex.size()){
                    arrayOfVertex.add(vertex);
                }
                else {
                    int flag = 0;
                    for(Double[] d : arrayOfVertex){
                        if (Arrays.equals(vertex,d)){
                            flag = 1;
                        }
                    }
                    if (flag ==0){
                        arrayOfVertex.add(vertex);
                    }
                }
            }
        }
        // Save all faces in arrayOfFaces
        for(Polygon p: polygons){
            Integer[] array = new Integer[3];
            int temp = 0;
            for(Vertex v: p.vertices){
                int i =0;
                for(Double[] d: arrayOfVertex){
                    double x = v.x;
                    double y = v.y;
                    double z = v.z;
                    double x1 = d[0];
                    double y1 = d[1];
                    double z1 = d[2];
                    if(x == x1 && y == y1 && z == z1 ){
                        array[temp] = i+1;                                        // Add the index in array
                        temp++;
                        break;
                    }
                    i++;
                }
            }
            arrayOfFaces.add(array);
        }

//        for(Integer[] x: arrayOfFaces){
//                System.out.println("f " + x[0] + x[1] + x[2]);
//        }
//        for(Double[] x: arrayOfVertex){
//                System.out.println("v " + x[0] + x[1] + x[2]);
//        }


            // Write it in a file
            File file = new File(fileName);
            File outputFile = new File(file.getAbsolutePath());
            FileWriter myWriter = new FileWriter(outputFile.getAbsolutePath());
            // Write all the vertices
            for(Double[] i:arrayOfVertex){
                myWriter.write("v "+ i[0] + " " + i[1] + " " + i[2] + "\n");
            }

            // Write all the faces
            for(Integer[] i: arrayOfFaces){
                myWriter.write("f "+ i[0] + " " + i[1] + " " + i[2] + "\n");
            }
            myWriter.close();
        }catch(Exception e){
            throw e;
        }
    }
}
