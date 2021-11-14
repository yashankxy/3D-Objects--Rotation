package Assignment;

import java.io.File;
import java.io.IOException;

public class Driver {
        public static void main(String [] args) throws Exception {
            Mesh mesh = new Mesh();
            mesh.setReader(new OBJMeshReader());
            mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\car.obj"));

            mesh.rotateYAxis(Math.PI/3);

            mesh.setWriter(new OBJMeshWriter());
            mesh.writeToFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\car_rotated.obj"));


            mesh.setWriter(new PLYMeshWriter());
            mesh.writeToFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\output\\car_rotated.ply"));


        }
}
