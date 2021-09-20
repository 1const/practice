package functions.UNDO_String_Builder;
import java.util.Arrays;

public class String_Builder {
    private char[] str;
    String_Builder(){
        str = new char[16];
    }
    String_Builder(int capacity){
        str = new char[capacity];
    }
    String_Builder(String string){
        str = new char[string.length() - 1];
        for (int i = 0; i < string.length(); i++) {
            str[i] = string.charAt(i);
        }
    }
    int capacity(){
        return str.length;
    }
    char charAt(int i){
        return str[i];
    }
    void setCharAt(int i,char symbol){
        str[i] = symbol;
    }
    char[] getChars(int start, int end, char[] arr, int bias){
        char[] returned = new char[end - start];
        for (int i = bias; i < bias + returned.length - 1; i++) {
            returned[i] = arr[i];
        }
        return returned;
    }
    void append(String string){
        char[] new_str = Arrays.copyOf(this.str, str.length + string.length() - 2);
        for (int i = 0; i < string.length(); i++) {
            new_str[str.length + i] = string.charAt(i);
        }
    }
    void insert(int i, String string){
        char[] new_str = new char[str.length + string.length() - 2];
        int k = 0;
        for (int j = 0; j < str.length ; j++) {
            if(j == i){
                for  (k = 0; k < string.length(); k++) {
                    new_str[j + k] = string.charAt(k);
                }
                new_str[j + k] = str[j + k];
            }
        }
        str = new_str;
    }
    void deleteCharAt(int i){
        char[] new_str = new char[str.length - 2];
        for (int j = 0; j < str.length - 2; j++) {
            if(j == i){
                j++;
            }
            new_str[j] = str[j];
        }
        str = new_str;
    }
    void delete(int start, int end){
        char[] new_str = new char[end - start];
        for (int i = 0; i < new_str.length; i++) {
            if(i == start){
                i+=end;
            }
            str[i] = new_str[i];
        }
        str = new_str;
    }
    String substring(int start,int end){
        char[] new_str = Arrays.copyOfRange(str, start, end);
        return new_str.toString();
    }
    String substring(int start){
        return substring(start, str.length);
    }
    void setLength(int size){
        str = Arrays.copyOf(str, size);
    }
    void replace(int start,int end, String string){

    }
    void reverse(){
        for(int i = str.length; i<= 0; i--){

        }
    }
    @Override
    public String toString(){
        return Arrays.toString(str);
    }
    class UndoStringBuilder{

    }
    public static void main(String[] args) {
        String_Builder builder = new String_Builder("hello");

    }
}
