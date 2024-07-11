public class Field {
    private char simbolo;

    public Field() {
        this.simbolo = ' ';
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        if (this.simbolo == ' ') {
            this.simbolo = simbolo;
        } else {
            System.out.println("Campo já usado!");
        }
    }
}
