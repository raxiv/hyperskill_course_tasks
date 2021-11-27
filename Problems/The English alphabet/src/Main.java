class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder sb = new StringBuilder();
        for (char i = 'A'; i <= 'Z'; i++) {
            if (i != 'Z') {
                sb.append(i + " ");
            } else {
                sb.append(i);
                return sb;
            }
        }
        return sb;
    }


}
