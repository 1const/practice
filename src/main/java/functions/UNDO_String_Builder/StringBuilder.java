package functions.UNDO_String_Builder;
import java.util.Arrays;

public class StringBuilder {
    private char[] str;
    StringBuilder(){
        str = new char[16];
    }
    StringBuilder(int capacity){
        str = new char[capacity];
    }
    StringBuilder(String string){
        str = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            str[i] = string.charAt(i);
        }
    }
    public int capacity(){
        return str.length;
    }                   //tested
    public char charAt(int i){
        return str[i];
    }                   //tested
    public void setCharAt(int i,char symbol){
        str[i] = symbol;
    }  //tested

    public void append(String string){                                //tested
        char[] new_str = Arrays.copyOf(str, str.length + string.length());
        for (int i = 0; i < string.length(); i++) {
            new_str[str.length + i] = string.charAt(i);
        }
        str = new_str;
    }
    public void insert(int i, String string){                        //tested
        char[] new_str = new char[str.length + string.length()];
        for (int j = 0; j < new_str.length; j++) {
            if(j < i) {
                new_str[j] = str[j];
            }
            else{
                for (int k = 0; k < string.length(); k++) {
                    new_str[j] = string.charAt(k);
                    j++;
                }
                break;
            }
        }
        int k = i;
        for (int j = i + string.length(); j < new_str.length; j++) {
            new_str[j] = str[k++];
        }
        str = new_str;
    }
    public void deleteCharAt(int i){                               //tested
        char[] new_str = new char[str.length - 1];
        int k=0;
        for (int j = 0; j < new_str.length; j++) {
            if(j == i){
                k++;
            }
            new_str[j] = str[k];
            k++;
        }
        str = new_str;
    }
    public void delete(int start, int end){                           //tested
        char[] new_str = new char[str.length - (end - start)];
        int j = 0;
        for (int i = 0; i < new_str.length; i++) {
            if(i == start){
                j+=end - start;
            }
            new_str[i] = str[j];
            j++;
        }
        str = new_str;
    }
    public String substring(int start,int end){                        //tested
        char[] new_str = Arrays.copyOfRange(str, start, end);
        return String.valueOf(new_str);
    }
    public String substring(int start){                                //tested
        return substring(start, str.length);
    }
    public void setLength(int size){                                  //tested
        str = Arrays.copyOf(str, size);
    }
    public void replace(int start,int end, String string){
        int j = 0;
        for (int i = start; i < end; i++) {
            str[i] = string.charAt(j);
            j++;
        }
    }
    public void reverse(){                                           //tested
        char[] new_str = new char[str.length];
        for(int i = str.length - 1; i>= 0; i--){
            new_str[str.length - 1 - i] = str[i];
        }
        str = new_str;
    }
    @Override
    public String toString(){
        return Arrays.toString(str);
    }
}
