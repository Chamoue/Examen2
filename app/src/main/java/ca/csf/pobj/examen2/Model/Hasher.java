package ca.csf.pobj.examen2.Model;

public class Hasher {

    private char[] changePostionString;
    private char[] reductionString;

    public Hasher() {
    }

    public String completeHashing(String string) {
        return this.hashItSmaller(this.hashDisplacement(this.hashItBigger(string)));
    }

    public String hashItBigger(String string) {
        String stringToAdd = string;
        while (string.length() < 1024) {
            string += stringToAdd;
        }
        return string;
    }

    public String hashDisplacement(String string) {

        this.changePostionString = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            this.changePostionString[i] = string.charAt(i);
        }

        for (int i = 0; i < string.length(); i++) {
            char oldChar = string.charAt(i);
            int newPosition = (i + oldChar) % string.length();
            char newChar = string.charAt(newPosition);

            this.changePostionString[newPosition] = oldChar;
            this.changePostionString[i] = newChar;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(this.changePostionString[i]);
        }

        return stringBuilder.toString();
    }

    public String hashItSmaller(String string) {

        StringBuilder stringBuilder = new StringBuilder();
        //reductionAlgoTry(string, stringBuilder);
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(string.charAt(i));
        }


        return stringBuilder.toString();
    }

    private void reductionAlgoTry(String string, StringBuilder stringBuilder) {
        for (int i = string.length() - 1; stringBuilder.length() > 16; i--) {

            char oldChar = stringBuilder.charAt(i);
            int newPosition = oldChar % stringBuilder.length() - 1;

            //char newValue =
        }
    }
}
