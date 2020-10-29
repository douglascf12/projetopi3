package entidade;

public class Filial {
    
    private int codigo;
    private String nome;
    private String estado;
    private String cidade;
    
    public Filial(int codigo, String nome, String estado, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Filial(String nome, String estado, String cidade) {
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}