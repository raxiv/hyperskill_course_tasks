class Cat {

    // write static and instance variablesp
    private String name;
    private int age;
    static int counter;

    public Cat(String name, int age) {
        // implement the constructor
        this.name = name;
        this.age = age;
        // do not forget to check the number of cats
        if (counter >= 5) {
            System.out.println("You have too many cats");
        }
        counter++;
    }

    public static int getNumberOfCats() {
        // implement the static method
        return counter;
    }
}