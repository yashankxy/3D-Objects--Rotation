package Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class OBJMeshReader implements MeshReader {
    @Override
    public HashSet<Polygon> read(String fileName) throws Exception {
        HashSet<Polygon> h = new HashSet<Polygon>();
        ArrayList<Double[]> arrayOfVertex = new ArrayList<Double[]>();     // [[ 5.1 1.2 0.3], [ 4.9 1.5 0.3], [3.8 1.4 0.5], [4.1 1.6 0.6] ]
        ArrayList<Integer[]> arrayOfFaces = new ArrayList<Integer[]>();    // [[1 2 3] [2 3 4]]

        try {
            BufferedReader sc = new BufferedReader(new FileReader(fileName));
            String line = "";

            // Read Vertices and faces
            while((line = sc.readLine())!= null){
                // Saving all The vertices
                if (line.contains("v")){
                    String[] x = line.split(" ");          //   x = {{v} {12} {4} {5}}
                    Double[] v = new Double[3];
                    for(int i = 1; i < x.length ; i++ ){
                        v[i-1] = Double.parseDouble(x[i]);               // Save all the double in array
                    }
                    arrayOfVertex.add(v);                                // save the vertex in array
                }

                // Saving all the faces
                else if(line.contains("f")){
                    String[] x = line.split(" ");            // x = {{f} {12} {4} {5}}
                    Integer[] v = new Integer[x.length-1];
                    for(int i = 1; i < x.length ; i++){
                        v[i-1] = Integer.parseInt(x[i]);
                    }
                    arrayOfFaces.add(v);
                }
            }



//         Correctly saved all Vertex and faces
//        int te = 5248;
//        for(Integer[] i: arrayOfFaces){
//            System.out.print(te + "   -> ");
//            for (Integer j : i){
//                System.out.print(j + "  ");
//            }
//            te++;
//            System.out.println("");
//        }
        //for loop to iterate over arrayOfFaces = [[1 2 3] [2 3 4]]

        Set<Integer>  sc1 = new HashSet<>();
        LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
        // SAVE
        for (int i = 0; i < arrayOfFaces.size(); i++){

            Integer[] k = arrayOfFaces.get(i);                              // k = [1 2 3]
            vertices = new LinkedHashSet<Vertex>();
            // for loop to iterate over k = [1 2 3]
            for(int c = 0; c < 3; c++){
//                if(sc1.contains(k[c]-1))
//                    continue;
                Double[] t = arrayOfVertex.get(k[c]-1); // [ 5.1 1.2 0.3]
                sc1.add(k[c] -1);

                Vertex ver = new Vertex(t[0], t[1], t[2]);  // Creates arrayOfVertex new Vertex
                vertices.add(ver); // LinkedHashSet += the values
            }

            Polygon p = new Polygon(vertices);
            h.add(p);   // HashSet += the Polygon
        }
        }catch(Exception e){
            throw e;
        }

        return h;
    }
}