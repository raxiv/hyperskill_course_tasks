import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        int index = sentence.toLowerCase().indexOf("the");

        if(index>=0){
            System.out.println(index);
        }else{
            System.out.println(-1);
        }
    }
}