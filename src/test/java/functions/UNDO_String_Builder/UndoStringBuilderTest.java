package functions.UNDO_String_Builder;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UndoStringBuilderTest {
    @Test
     public void test(){
        UndoStringBuilder undoStringBuilder = new UndoStringBuilder("Hello");
        System.out.println(undoStringBuilder.toString());
        undoStringBuilder.reverse();
        System.out.println(undoStringBuilder.toString());
        undoStringBuilder.undo();
        System.out.println(undoStringBuilder.toString());
    }
}