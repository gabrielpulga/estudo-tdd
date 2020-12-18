package one;

public class camelCaseConverter {
    public String convert(String nome) {
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }
}
