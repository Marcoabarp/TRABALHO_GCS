public class Departamento {

    private int id;
    private String nome;
    private double limitePedido;

    public Departamento(int id, String nome, double limitePedido) {
        this.id = id;
        this.nome = nome;
        this.limitePedido = limitePedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLimitePedido() {
        return limitePedido;
    }

    public void setLimitePedido(double limitePedido) {
        this.limitePedido = limitePedido;
    }
}
