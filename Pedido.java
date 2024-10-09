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
  
    public double calculaTotal(int i){
        double total = 0;
       for (int i =0; i<= items.size()) {

            if (1<5){
                String teste = String.valueOf(Status.PENDENTE);

            }
                    double valor = items(i).get(i).getValor(i);
                int quantidade = items(i).get(i).get;
            total += valor * quantidade;
                            i++;
       }
        return total;

    }


    public String getId() {
      return String.valueOf(id);
    }
}


