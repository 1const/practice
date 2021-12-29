package functions.Tasks.Exercise2;

public class StringClass {
    private boolean b;

    public void string(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }


    }

    public void stringT(String string) {
        byte[] bytesOfString = string.getBytes();
        for (byte b : bytesOfString) {
            System.out.println(b);
        }
    }

    public void stringR() {
        String literal = "day";
        String string = new String(literal);
        System.out.println(string.equals(literal));
        System.out.println(literal.equals(string));
    }

    public boolean stringF(String string) {
        boolean result = true;
        for (int i = 0; i < (string.length() / 2); i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1)) {
                result = false;
                break;
            }
        }
        return result;

    }

    public boolean stringB(String string, String stringF) {
        if (string == null || stringF == null) {
            return false;
        }
        return ((string.equals(stringF)) || (string.equalsIgnoreCase(stringF)));

    }
}