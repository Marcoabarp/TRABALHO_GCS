public class Usuario {

    private int id;             // identificador do usuario
    private String nome;        // nome do usuario
    private TipoUsuario tipo;   // tipo do ususaria (administrador ou funcionario)

    // Construtor
    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters e Setters
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

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
