package functions.UNDO_String_Builder;

import java.util.Collection;
import java.util.Stack;

public class UndoStringBuilder {
    Stack<Commands> actions = new Stack<>();
    StringBuilder stringBuilder;

    public UndoStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public UndoStringBuilder(int capacity) {
        stringBuilder = new StringBuilder(capacity);
    }

    public UndoStringBuilder(String string) {
        stringBuilder = new StringBuilder(string);
    }

    public void delete(int start, int end) {
        Commands delete = new Commands() {
            String substring = stringBuilder.substring(start, end);

            @Override
            public void undo() {
                stringBuilder.insert(start, substring);
            }
        };
        stringBuilder.delete(start, end);
        actions.push(delete);
    }

    public void append(String string){
        Commands append = new Commands() {
            @Override
            public void undo() {
                stringBuilder.setLength(stringBuilder.capacity() - string.length());
            }
        };
        stringBuilder.append(string);
        actions.push(append);
    }

    public void insert(int i, String string){
        Commands insert = new Commands() {
            @Override
            public void undo() {
                stringBuilder.delete(i, i + string.length());
            }
        };
        stringBuilder.insert(i, string);
        actions.push(insert);
    }

    public void deleteCharAt(){
        Commands deletecharat = new Commands() {
            @Override
            public void undo() {

            }
        };
     //   stringBuilder.
     //   actions.push(deletecharat);
    }

    public void substring(){
    }

    public void setLength(){

    }

    public void replace(){

    }

    public void reverse(){
        Commands reverse = new Commands() {
            @Override
            public void undo() {
                stringBuilder.reverse();
            }
        };
        stringBuilder.reverse();
        actions.push(reverse);
    }

    public void undo() {
        if (!actions.empty()) {
            actions.pop().undo();
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
