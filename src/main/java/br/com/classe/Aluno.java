package br.com.classe;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Aluno extends Pessoa{

     String dataMatricula;
     String nomeEscola;
     String serieMatriculado;

     List <Disciplina> disciplinas = new ArrayList<>();

    public double getMediaNota(){
        double calculoMedia = 0;
        for (Disciplina disciplina : this.disciplinas){
            calculoMedia += disciplina.getNota();
        }
        return calculoMedia / disciplinas.size();
    }

    public String getAlunoAprovado(){
        double media = this.getMediaNota();
        if (media >= 7){
            return StatusAluno.APROVADO;
        }else if (media >=6){
            return StatusAluno.RECUPERACAO;
        }
        return StatusAluno.REPROVADO;
    }
    public static String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", registroGeral='" + registroGeral + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
