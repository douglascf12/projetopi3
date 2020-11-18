/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author w_olv
 */
public enum CargoEnum {
    admin ("admin"),GerenteGeral("GerenteGeral"), Vendedor("Vendedor"), GerenteFilial("Gerente Filial"), Analista("Analista de Rede");
     
    private final String cargo;
    
    CargoEnum(String perfil){
        this.cargo = perfil;
    }
    public String getCargoEnum(){
        return this.cargo;
    }
}
