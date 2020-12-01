package utils;

import entidade.Funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        String senhaCripto = func.codificarSenha("admin");
        System.out.println(senhaCripto);
    }
}