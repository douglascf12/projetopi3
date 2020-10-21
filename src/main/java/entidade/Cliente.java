/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;



//@Getter
//@Setter
public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String  dataNascimento;
    private String endereco;
    private String sexo;
    
      public Cliente(String nome, String email, String cpf, String dataNascimento, String endereco, String sexo ) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.email = dataNascimento;
        this.email = endereco;
        this.email = sexo;
        
        
   
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String data_nasc) {
        this.dataNascimento = data_nasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", data_nasc=" + dataNascimento + ", endereco=" + endereco + ", sexo=" + sexo + '}';
    }

}
