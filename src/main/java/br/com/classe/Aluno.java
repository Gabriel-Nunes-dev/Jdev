package br.com.classe;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Aluno {

     String nome;
     int idade;
     String dataNascimento;
     String registroGeral;
     String numeroCpf;
     String nomePai;
     String nomeMae;
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
            return "Aluno Aprovado";
        }else if (media >=6){
            return "Aluno em recuperação";
        }
        return "Aluno Reprovado";
    }


}
