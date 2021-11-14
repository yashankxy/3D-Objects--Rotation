package Assignment;

public class Vertex extends GraphicalObject {
    double x;
    double y;
    double z;

    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Double.compare(vertex.x, x) == 0 && Double.compare(vertex.y, y) == 0 && Double.compare(vertex.z, z) == 0;
    }

    @Override
    public int hashCode() {
        System.out.println(this.x +" "+this.y +" "+this.z +" "+(int)(3*x+3*y+3*z));
        return (int)(3*x+3*y+3*z);
    }

    @Override
    public String toString() {
        return x + " " + y + " " + z + " "  ;
    }

    @Override
    void transform(double[][] transformedMatrix) {
//        double[][] x = new double[3][1];        // Doubt should it xyz or a matrix
//        DecimalFormat df = new DecimalFormat("#.####");

//         *       |  1  0   0   | |vx|       |        vx       |
//         *       |  0 𝑐𝑜𝑠𝜃 −𝑠𝑖𝑛𝜃 | |vy|  =    |  𝑣𝑦𝑐𝑜𝑠𝜃 − 𝑣𝑧𝑠𝑖𝑛𝜃  |
//         *       |_ 0 𝑠𝑖𝑛𝜃 𝑐𝑜𝑠𝜃 _| |vz|       |_ 𝑣𝑦𝑠𝑖𝑛𝜃 + 𝑣𝑧𝑐𝑜𝑠𝜃 _|

        double r = (transformedMatrix[0][0] * this.x + transformedMatrix[0][1] * this.y + transformedMatrix[0][2] * this.z);
        r = r * 100000;
        double r1 = (transformedMatrix[1][0] * this.x + transformedMatrix[1][1] * this.y + transformedMatrix[1][2] * this.z);
        r1 = r1 * 100000;
        double r2 = transformedMatrix[2][0] * this.x + transformedMatrix[2][1] * this.y + transformedMatrix[2][2] * this.z;
        r2 = r2 * 100000;

        double a = Math.round(r) ;
        double b = Math.round(r1);
        double c = Math.round( r2 );
        a /= 100000;
        b /= 100000;
        c /= 100000;

        this.x = a;
        this.y = b;
        this.z = c;
    }
}
