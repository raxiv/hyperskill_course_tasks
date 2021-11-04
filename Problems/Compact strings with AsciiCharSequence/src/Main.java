import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence/* extends/implements */ {

    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return this.array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
         array = array.clone();
         byte[] array1 = Arrays.copyOfRange(array,start,end);
         return new AsciiCharSequence(array1);
    }

    @Override
    public String toString() {
        return new String(array);
    }
    // implementation
}