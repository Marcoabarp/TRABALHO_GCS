public enum StatusPedido {
    APROVADO("APROVADO"),

    REPROVADO("REPROVADO"),

    ABERTO("ABERTO");

    private String label;

     StatusPedido(String label) {
        this.label = label;
    }
}
