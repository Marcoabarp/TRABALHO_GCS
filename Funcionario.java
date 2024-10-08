import java.util.ArrayList;

public class Funcionario extends Usuario {

    private Departamento departamento;
    private List<Pedido> pedidos; // Lista de pedidos registrados.

    public Funcionario(int id, String nome, Departamento departamento) {
        super(id, nome); // Atributos da classe Usuário
        this.departamento = departamento;
        this.pedidos = new ArrayList<>(); // Inicializa a lista de pedidos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void registrarPedido(Pedido pedido) {
        // Verifica se o pedido é válido (ex: departamento correto, limite, etc.)
        if (pedido.getDepartamentoSolicitante().equals(this.departamento)) {
            pedidos.add(pedido); // Adiciona o pedido à lista de pedidos do funcionário
            System.out.println("Pedido registrado com sucesso: " + pedido.getId());
        } else {
            System.out.println("Erro: Departamento do pedido não corresponde ao departamento do funcionário.");
        }
    }
}
