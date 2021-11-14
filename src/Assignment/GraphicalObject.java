package Assignment;

public abstract class GraphicalObject {
    /**
     * An abstract method that takes a two-dimensional matrix of double
     * representing the transformation matrix.
     */
    abstract void transform(double[][] transformedMatrix);

    void rotateXAxis(double theta){
        /**
         * A concrete method that rotates the graphical object about the x-axis. It takes
         * one argument of type double representing θ.
         * To rotate a vertex 𝑣 = (𝑣𝑥, 𝑣𝑦, 𝑣𝑧) about
         * the x-axis with angle θ, we can multiply the following matrix by the
         * column vector representing 𝑣:
         * 𝑅𝑥(𝜃) =
         *       |  1  0   0   |
         *       |  0 𝑐𝑜𝑠𝜃 −𝑠𝑖𝑛𝜃 |
         *       |_ 0 𝑠𝑖𝑛𝜃 𝑐𝑜𝑠𝜃 _|
         *
         * That is, 𝑣 would be transformed into 𝑣′ =
         *       |  1  0   0   | |vx|       |        vx       |
         *       |  0 𝑐𝑜𝑠𝜃 −𝑠𝑖𝑛𝜃 | |vy|  =    |  𝑣𝑦𝑐𝑜𝑠𝜃 − 𝑣𝑧𝑠𝑖𝑛𝜃  |
         *       |_ 0 𝑠𝑖𝑛𝜃 𝑐𝑜𝑠𝜃 _| |vz|       |_ 𝑣𝑦𝑠𝑖𝑛𝜃 + 𝑣𝑧𝑐𝑜𝑠𝜃 _|
         */
        double[][] rx = {
                {1,         0,          0},
                {0, Math.cos(theta), -Math.sin(theta)},
                {0, Math.sin(theta),  Math.cos(theta)}
        };
        transform(rx);
    }

    void rotateYAxis(double theta){
        /**
         * A concrete method that rotates the graphical object about the y-axis. It takes
         * one argument of type double representing θ.
         * Similarly, the following matrices can be used to rotate 𝑣 about the y-axis
         * 𝑅y(𝜃) =
         *       |  𝑐𝑜𝑠𝜃   0   𝑠𝑖𝑛𝜃  |
         *       |   0    1    0   |
         *       |_ −𝑠𝑖𝑛𝜃  0   𝑐𝑜𝑠𝜃 _|
         */
        double[][] ry = {
                { Math.cos(theta), 0, Math.sin(theta)},
                {0, 1, 0},
                {-Math.sin(theta), 0, Math.cos(theta) }
        };
        transform(ry);
    }

    void rotateZAxis(double theta){
        /**
         * A concrete method that rotates the graphical object about the z-axis. It takes
         * one argument of type double representing θ.
         * Similarly, the following matrices can be used to rotate 𝑣 about the y-axis
         * 𝑅z(𝜃) =
         *        |  𝑐𝑜𝑠𝜃  −𝑠𝑖𝑛𝜃  0   |
         *        |  𝑠𝑖𝑛𝜃   𝑐𝑜𝑠𝜃   0  |
         *        |_   0    0    1 _|
         */
        double[][] rz = {
                {Math.cos(theta), -Math.sin(theta), 0},
                {Math.sin(theta),  Math.cos(theta), 0},
                {0, 0, 1}
        };
//        z[0][0] = rz[0][0] * ___ + rz[0][1] * ___ + rz[0][2] * ___;
//        z[1][0] = rz[1][0] * ___ + rz[1][1] * ___ + rz[1][2] * ___;
//        z[2][0] = rz[2][0] * ___ + rz[2][1] * ___ + rz[2][2] * ___;
        transform(rz);
    }

}
