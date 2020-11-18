package entidade;

import utils.CargoEnum;

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

    public Funcionario() {
    }

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

    public boolean isAdmin() {
        return this.cargo.equalsIgnoreCase("admin");
    }

    public boolean isGerenteG() {
        return this.cargo.equalsIgnoreCase("Gerente Geral");
    }

    public boolean isGerenteF() {
        return this.cargo.equalsIgnoreCase("Gerente Filial");
    }

    public boolean isAnalista() {
        return this.cargo.equalsIgnoreCase("Gerente Filial");
    }

    public boolean isVendedor() {
        return this.cargo.equalsIgnoreCase("Vendedor");
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
