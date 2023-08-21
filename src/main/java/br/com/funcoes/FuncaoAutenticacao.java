package br.com.funcoes;

import br.com.interfaces.PermitirAcesso;

public class FuncaoAutenticacao {

    private PermitirAcesso permitirAcesso;

//    public boolean autenticar(){
//        return permitirAcesso.autenticar();
//    }

    public FuncaoAutenticacao(PermitirAcesso acesso){
        this.permitirAcesso = acesso;
    }
}
