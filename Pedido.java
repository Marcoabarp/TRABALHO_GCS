import java.util.ArrayList;
import java.util.Date;

public class Pedido{

    private int id;
    private Funcionario funcionarioSolicitante;
    private Departamento departamentoSolicitante;
    private Date dataPedido;
    private Date dataConclusao;
    private StatusPedido status;
    private List<Item> itens;
    private double valorTotal;

  public Pedido(int id, Funcionario funcionarioSolicitante, Departamento departamentoSolicitante) {
      this.id = id;
      this.funcionarioSolicitante = funcionarioSolicitante;
      this.departamentoSolicitante = departamentoSolicitante;
      this.dataPedido = new Date();
      this.dataConclusao = null; //
      this.itens = new ArrayList<>();
      this.status = StatusPedido.ABERTO;
      this.valorTotal = 0.0;
  }

    public void adicionarItem(Item item) {
        itens.add(item);
        calcularValorTotal();
    }

    public double calcularValorTotal() {
        valorTotal = 0;
        for (Item item : itens) {
            valorTotal += item.calcularTotal();
        }
        return valorTotal;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Funcionario getFuncionarioSolicitante() {
        return funcionarioSolicitante;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao; // Método para definir a data de conclusão
    }

    public double getValorTotal() {
        return valorTotal; // Método para obter o valor total
    }

    public String getId() {
        return String.valueOf(id);
    }
}




