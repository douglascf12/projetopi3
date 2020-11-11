package entidade;

public class Funcionario {

    int cpfFunc;
    String nomeFunc;
    int codFilial;
    String cargoFunc;
    int telefoneFunc;
    String enderecoFunc;
    String dataNascFunc;    
    String sexoFunc;
    String usuarioFunc;
    String senhaFunc;
    
    

    public Funcionario(int cpfFunc, String nomeFunc, int codFilial, String cargo, int telefoneFunc, String enderecoFunc, String dataNascFunc, String sexoFunc, String usuario, String senha) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.codFilial = codFilial;
        this.cargoFunc = cargo;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.sexoFunc = sexoFunc;
        this.usuarioFunc = usuario;
        this.senhaFunc = senha;
    }
    
    public Funcionario(int cpfFunc, String nomeFunc, int codFilial, String cargo, int telefoneFunc, String enderecoFunc, String dataNascFunc, String sexoFunc, String usuario) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.codFilial = codFilial;
        this.cargoFunc = cargo;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.sexoFunc = sexoFunc;
        this.usuarioFunc = usuario;
    }

    public Funcionario(int cpfFunc, String nomeFunc, String dataNascFunc, int telefoneFunc, String enderecoFunc, String sexoFunc) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.sexoFunc = sexoFunc;
    }

    public Funcionario(int cpf, String nome, String cargo, String usuario) {
        this.cpfFunc = cpf;
        this.nomeFunc = nome;
        this.cargoFunc= cargo;
        this.usuarioFunc = usuario;
    }
    
    public boolean isAdmin() {
        return this.cargoFunc.equalsIgnoreCase("admin");
    }

    public int getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(int cpfFunc) {
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
        return cargoFunc;
    }

    public void setCargo(String cargo) {
        this.cargoFunc = cargo;
    }

    public int getTelefoneFunc() {
        return telefoneFunc;
    }

    public void setTelefoneFunc(int telefoneFunc) {
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
        return usuarioFunc;
    }

    public void setUsuario(String usuario) {
        this.usuarioFunc = usuario;
    }

    public String getSenha() {
        return senhaFunc;
    }

    public void setSenha(String senha) {
        this.senhaFunc = senha;
    }
    
}