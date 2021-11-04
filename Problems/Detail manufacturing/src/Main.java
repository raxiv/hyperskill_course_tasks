class ManufacturingController {

    static int numberOfproduct;


    public static String requestProduct(String product) {
        // write your code here
        numberOfproduct++;
        return numberOfproduct + "." + " Requested " + product;

    }

    public static int getNumberOfProducts() {
        // write your code here
        return numberOfproduct;
    }
}