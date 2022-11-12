public abstract class FormatarFonte {

    // Atributos de cor da fonte com cores 8 bits
    private int corBitsFonte = 255; // Escala de no máximo de 255 bits, então pode modificar os valores nessa escala
    // para testar cores diferentes
    private String fonte8Bits = "\u001b[38;5;" + corBitsFonte + "m";

    // Atributos de cor de fundo
    private String fundoPreto = "\u001b[40m";
    private String fundoVermelho = "\u001b[41m";
    private String fundoVerde = "\u001b[42m";
    private String fundoAmarelo = "\u001b[43m";
    private String fundoAzul = "\u001b[44m";
    private String fundoMagenta = "\u001b[45m";
    private String fundoCiano = "\u001b[46m";
    private String fundoBranco = "\u001b[47m";

    // Atributos de cor de fundo com cores 8 bits
    private int corBitsFundo = 255; // Escala de no máximo de 255 bits, então pode modificar os valores nessa escala
    // para testar cores diferentes
    private String fundo8Bits = "\u001b[48;5;" + corBitsFundo + "m";

    // Atributo para redefinir
    private static final String REDEFINIR = "\u001b[m";

    public static String getREDEFINIR() {
        return REDEFINIR;
    }

    // Método para mudar a cor da fonte
    // CORES: Preta - 0; Vermelha - 1; Verde - 2;
    // Amarelo - 3; Azul - 4; Magenta - 5; Ciano - 6; Branca - 7
    public static String mudaCorFonte(String texto, int cor) {
        if (cor >= 0 & cor <= 7) {
            String textoCor = "\u001b[3" + cor + "m" + texto + getREDEFINIR();
            texto = textoCor;
        }
        return texto;
    }

    // Método para mudar o destaque da fonte
    // DESTAQUES: Negrito - 1; Itálico - 3; Sublinhado - 4;
    // Piscando - 5; Invertido - 7; Riscado - 9
    public static String mudaDestaqueFonte(String texto, int destaque) {
        if (destaque == 1 | (destaque >= 3 & destaque <= 5) | destaque == 7 | destaque == 9) {
            String textoDestaque = "\u001b[" + destaque + "m" + texto + getREDEFINIR();
            texto = textoDestaque;
        }
        return texto;
    }

    // Método para mudar a cor e o destaque da fonte
    // CORES: Preta - 0; Vermelha - 1; Verde - 2;
    // Amarelo - 3; Azul - 4; Magenta - 5; Ciano - 6; Branca - 7
    // DESTAQUES: Negrito - 1; Itálico - 3; Sublinhado - 4;
    // Piscando - 5; Invertido - 7; Riscado - 9
    public static String mudaCorDestaqueFonte(String texto, int cor, int destaque) {
        if ((destaque == 1 | (destaque >= 3 & destaque <= 5) | destaque == 7 | destaque == 9)
                && (cor >= 0 & cor <= 7)) {
            String textoAlterado = "\u001b[" + destaque + "m" + "\u001b[3" + cor + "m" + texto + getREDEFINIR();
            texto = textoAlterado;
        }
        return texto;
    }
}