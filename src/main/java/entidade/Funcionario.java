package entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Funcionario {

    int cpfFunc;
    String nomeFunc;
    String dataNascFunc;
    int telefoneFunc;
    String enderecoFunc;
    String sexoFunc;

    public Funcionario(int cpfFunc, String nomeFunc, String dataNascFunc, int telefoneFunc, String enderecoFunc, String sexoFunc) {
        this.cpfFunc = cpfFunc;
        this.nomeFunc = nomeFunc;
        this.dataNascFunc = dataNascFunc;
        this.telefoneFunc = telefoneFunc;
        this.enderecoFunc = enderecoFunc;
        this.sexoFunc = sexoFunc;
    }

    

    
}
