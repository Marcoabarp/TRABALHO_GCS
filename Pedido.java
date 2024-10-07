import java.util.ArrayList;

public class Pedido{

    private String funcionario;
    private String departamento;
    private String data;
    private String data_conclusao;
    private ArrayList<item> items = new ArrayList<>();

    public Pedido(String funcionario, String data, String data_conclusao, String departamento) {
        this.funcionario = funcionario;
        this.data = data;
        this.data_conclusao = data_conclusao;
        this.departamento = departamento;

    }
    public double calculatotal(int i){
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



    public String getFuncionario() {
                return funcionario;
            }

            public void setFuncionario(String funcionario) {
            this.funcionario = funcionario;
                 }

    public ArrayList<item> getItems() {
            return items;
        }

    public void setItems(ArrayList<item> items) {
    this.items = items;
    }

    public String getData_conclusao() {
         return data_conclusao;
    }

        public void setData_conclusao(String data_conclusao) {
        this.data_conclusao = data_conclusao;
        }
public void main() {
}

}


