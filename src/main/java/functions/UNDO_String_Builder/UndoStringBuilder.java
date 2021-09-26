package functions.UNDO_String_Builder;

import java.util.ArrayList;
import java.util.Stack;

public class UndoStringBuilder extends StringBuilder{
    Stack<commands> actions = new Stack<>();
    public UndoStringBuilder(){
        super();
    }
    public UndoStringBuilder(int capacity){
        super(capacity);
    }
    public UndoStringBuilder(String string){
        super(string);
    }
    void delete(int start, int end) {
        commands delete = new commands() {
            @Override
            public void undo() {
               // UndoStringBuilder.super.insert(start, UndoStringBuilder.super.substring(start, end));
            }
        };
        super.delete(start, end);
        actions.push(delete);
    }
}
