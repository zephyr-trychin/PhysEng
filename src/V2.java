public class V2 {
    double[] V2 = new double[2];
    public V2() {
    }

    public V2 (double x, double y) {
        V2[0] = x;
        V2[1] = y;
    }

    public void set (double x, double y, double z) {
        V2[0] = x;
        V2[1] = y;
    }
    public static double dotProd(V2 in1, V2 in2) {
        return (in1.V2[0]*in2.V2[0])+
                (in1.V2[1]*in2.V2[1]);
    }

    public static double crossProd(V2 in1, V2 in2){
        return (in1.V2[0] * in2.V2[1]) - (in1.V2[1] * in2.V2[0]);
    }

    public V2 normalize () {
        double length = Math.sqrt(
                V2[0]*V2[0]+
                        V2[1]*V2[1]
        );
        return new V2(
                V2[0]/length,
                V2[1]/length
        );
    }

    public double length () {
        return Math.sqrt(
                V2[0]*V2[0]+
                        V2[1]*V2[1]);
    }
}