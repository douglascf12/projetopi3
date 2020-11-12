package entidade;

public class Funcionario {

    String cpfFunc;
    String nomeFunc;
    int codFilial;
    String cargo;
    String telefoneFunc;
    String enderecoFunc;
    String dataNascFunc;    
    String sexoFunc;
    String usuario;
    String senha;

    public Funcionario(String cpfFunc, String nomeFunc, int codFilial, String cargo, String telefoneFunc, String enderecoFunc, String dataNascFunc, String sexoFunc, String usuario, String senha) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.codFilial = codFilial;
        this.cargo = cargo;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.sexoFunc = sexoFunc;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Funcionario(String cpfFunc, String nomeFunc, int codFilial, String cargo, String telefoneFunc, String enderecoFunc, String dataNascFunc, String sexoFunc, String usuario) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.codFilial = codFilial;
        this.cargo = cargo;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.sexoFunc = sexoFunc;
        this.usuario = usuario;
    }

    public Funcionario(String cpfFunc, String nomeFunc, String dataNascFunc, String telefoneFunc, String enderecoFunc, String sexoFunc) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.sexoFunc = sexoFunc;
    }

    public Funcionario(String cpf, String nome, String cargo, String usuario) {
        this.cpfFunc = cpf;
        this.nomeFunc = nome;
        this.cargo = cargo;
        this.usuario = usuario;
    }
    
    public boolean isAdmin() {
        return this.cargo.equalsIgnoreCase("admin");
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefoneFunc() {
        return telefoneFunc;
    }

    public void setTelefoneFunc(String telefoneFunc) {
        this.telefoneFunc = telefoneFunc;
    }

    public String getEnderecoFunc() {
        return enderecoFunc;
    }

    public void setEnderecoFunc(String enderecoFunc) {
        this.enderecoFunc = enderecoFunc;
    }

    public String getDataNascFunc() {
        return dataNascFunc;
    }

    public void setDataNascFunc(String dataNascFunc) {
        this.dataNascFunc = dataNascFunc;
    }

    public String getSexoFunc() {
        return sexoFunc;
    }

    public void setSexoFunc(String sexoFunc) {
        this.sexoFunc = sexoFunc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}