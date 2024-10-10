public enum TipoUsuario {
    // Constantes
    FUNCIONARIO("Funcionário"), 
    ADMINISTRADOR("Administrador");

    // Atributo
    private String tipo;

    // Construtor
    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    // Getter
    public String getTipo() {
        return tipo;
    }
}
