import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Usuario {

    private Departamento departamento;
    private List<Pedido> pedidos;

    public Funcionario(int id, String nome, Departamento departamento) {
        super(id, nome);
        this.departamento = departamento;
        this.pedidos = new ArrayList<>();
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido.getDepartamentoSolicitante().equals(this.departamento)) {
            pedidos.add(pedido);
            System.out.println("Pedido registrado com sucesso: " + pedido.getId());
        } else {
            System.out.println("Erro: Departamento do pedido não corresponde ao departamento do funcionário.");
        }
    }
}
