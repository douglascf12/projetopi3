package utils;

import entidade.Funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        String senha = func.codificarSenha("admin");
        System.out.println(senha);
    }
}
