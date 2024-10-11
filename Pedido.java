import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido{

    private int id;
    private Funcionario funcionarioSolicitante;
    private Departamento departamentoSolicitante;
    private Date dataPedido;
    private Date dataConclusao;
    private StatusPedido status;
    private List<Item> itens;
    private double valorTotal;

  public Pedido(int id, Funcionario date, Departamento funcionario) {
      this.id = id;
      this.funcionarioSolicitante = date;
      this.departamentoSolicitante = funcionario;
      this.dataPedido = new Date();
      this.dataConclusao = null; //
      this.itens = new ArrayList<>();
      this.status = StatusPedido.ABERTO;
      this.valorTotal = 0.0;
  }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionarioSolicitante() {
        return funcionarioSolicitante;
    }

    public void setFuncionarioSolicitante(Funcionario funcionarioSolicitante) {
        this.funcionarioSolicitante = funcionarioSolicitante;
    }

    public Departamento getDepartamentoSolicitante() {
        return departamentoSolicitante;
    }

    public void setDepartamentoSolicitante(Departamento departamentoSolicitante) {
        this.departamentoSolicitante = departamentoSolicitante;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionarItem(Item item) {

        itens.add(item);
        Integer quantidade = item.getQuantidade();

        if(quantidade != 0 || quantidade != null) {
            calcularValorTotal(quantidade);
        }

    }

    public double calcularValorTotal(int quantidade) {

        for (Item item : itens) {
            valorTotal += item.calcularTotal(valorTotal, quantidade);
        }
        return valorTotal;
    }

}




