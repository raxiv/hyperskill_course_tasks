class Application {

    String name;

    void run(String[] args) {
        // implement me
        System.out.println(this.name);
        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i]);
        }
    }

}