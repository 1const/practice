package functions.alorithm_BMH;
import java.util.Arrays;
import java.util.Scanner;

public class algorithm_BMH {

    private static void array_creator(int[] arr, String source, String image, int length) {
        arr[length] = image.length();
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = length - i;
            for (int j = i + 1; j < length; j++) {
                if (image.charAt(i) == image.charAt(j)) {
                    arr[i] = arr[j];
                    break;
                }
            }
            if (image.charAt(length) == image.charAt(i)) {
                arr[length] = arr[i];

            }
        }
    }
    static void search(String source, String image){
        int[] arr = new int[image.length()];
        final int length = image.length() - 1;
        array_creator(arr, source, image, length);
        boolean result = true;
        int bias = image.length() - 1;
        while (bias < source.length()){
            if(source.charAt(bias) != image.charAt(length)) {
                result = true;
                for (int i = 0; i < arr.length; i++) {
                    if (source.charAt(bias) == image.charAt(i)) {
                        result = false;
                        bias += arr[i];
                        break;
                    }
                }
                if(result){
                    bias += length;
                }
            }
            else{
                for(int j = length - 1; j >=0; j--){
                    result = true;
                    if(image.charAt(j) != source.charAt(bias - (length - j))){
                        bias += arr[length];
                        result = false;
                        break;
                    }
                }
                if(result){
                    System.out.println(bias + 1 - image.length());
                    break;
                }
            }
        }
        if(!result)
            System.out.println("NO MATCHES.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("write a source:");
        String source = scanner.next();
        System.out.println("write a image:");
        String image = scanner.next();
        search(source, image);
    }
}
