public class Main {

    public static void main(String[] args) {
    // write your program here
        int howMany = 2;
        for (Secret secret:Secret.values()) {
     String text = secret.toString();
     String cut = text.substring(0,4);
            if (cut.equals(text)) {
                howMany++;
            }
        }

        System.out.println(howMany);
    }
}

//sample enum for inspiration
 //enum Secret {
 // STAR, CRASH, START, // ...
//}
