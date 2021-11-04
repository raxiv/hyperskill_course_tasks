class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (char i = 'A'; i <= 'Z'; i++) {
            if(i=='Z'){
                sb.append(i);
            }else{sb.append(i+ " ");}

        }
String sbs = sb.toString();
        return sb;
    }





    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}