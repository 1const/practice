package functions.binary_search;
import java.util.Scanner;

class binary_search {
    private int[] arr;
    private int search;
    private int of;
    private int from = 0;
    private int N = (of - from) / 2;
    static boolean result = false;

    binary_search(int[] arr, int search) {
        of = arr.length -1;
        this.arr = arr;
        this.search = search;
    }

    boolean func() {
        if(search>arr[N]) {
            from = N;
            if((of - from)>1) {
                N = N + (of - from) / 2;
                func();
            }
            else if(search==arr[N+1]){
                return true;
            }
        }
        if(search < arr[N]) {
            of = N;
            if((of - from)>1) {
                N = from + (of - from) / 2;
                func();
            }
            else if(search==arr[N-1]){
                return true;
            }
        }
        else if(search==arr[N]){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9 ,11 ,12};
        int a;
        Scanner scanner = new Scanner(System.in);
        System.out.println("search number:");
        a = scanner.nextInt();
        binary_search obj = new binary_search(arr, a);
        System.out.println(obj.func());
    }
}