public class Item extends Pedido{
    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private double total;

    public Item(String descricao, double valorUnitario, int quantidade, int id, Funcionario funcionarioSolicitante, Departamento departamentoSolicitante) {
        super(id, funcionarioSolicitante, departamentoSolicitante);
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return total;
    }

    public double calcularTotal(double valorUnitario, int quantidade) {
        total = valorUnitario * quantidade;
        return total;
    }
}