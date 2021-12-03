package functions.UNDO_String_Builder;

import org.junit.Test;

import java.util.Arrays;

public class Test2 {
    class qwe{
        int a = 2;
    }
    @Test
    public void test(){
        qwe[] t = new qwe[5];
        for (int i = 0; i < 5; i++) {
            t[i] = new qwe();
        }
        System.out.println(Arrays.stream(t).mapToDouble(test -> test.a).sum());
    }
}
