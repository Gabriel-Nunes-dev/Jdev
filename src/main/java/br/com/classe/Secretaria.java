package br.com.classe;

import br.com.interfaces.PermitirAcesso;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Secretaria extends Pessoa implements PermitirAcesso {

    private String login;
    private String senha;

    @Override
    public boolean autenticar(String login, String senha) {
        return login.equals("admin") && senha.equals("admin");
    }
}
