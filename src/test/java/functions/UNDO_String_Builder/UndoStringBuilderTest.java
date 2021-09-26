package functions.UNDO_String_Builder;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UndoStringBuilderTest {
    @Test
     public void test(){
        StringBuilder string = new StringBuilder("hello");
       // string.replace(1, 3);
        System.out.println(string.toString());
    }
}