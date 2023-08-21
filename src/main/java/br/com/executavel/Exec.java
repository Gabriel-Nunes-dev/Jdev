package br.com.executavel;

import br.com.classe.Disciplina;
import br.com.classe.Secretaria;
import br.com.classe.StatusAluno;
import br.com.classe.Aluno;
import br.com.funcoes.FuncaoAutenticacao;
import br.com.interfaces.PermitirAcesso;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static br.com.classe.Aluno.formatarCPF;

public class Exec {
    public static void main(String[] args) {

        String login = JOptionPane.showInputDialog("Informe o login:");
        String senha = JOptionPane.showInputDialog("Informe a senha:");

        Secretaria secretaria = new Secretaria();

        if (secretaria.autenticar(login, senha)) {

            List<Aluno> alunos = new ArrayList<>();
            HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

            for (int qtdAluno = 1; qtdAluno <= 3; qtdAluno++) {//quantidade de alunos

                String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtdAluno + "? ");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do aluno? "));
                String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
                cpf = formatarCPF(cpf);

                Aluno aluno = new Aluno();
                aluno.setNome(nome);
                aluno.setIdade(idade);
                aluno.setCpf(cpf);

                String nomeDisciplina = JOptionPane.showInputDialog("Qual a Disciplina? ");
                Disciplina disciplina = new Disciplina();
                disciplina.setDisciplina(nomeDisciplina);

                for (int pos = 1; pos <= 1; pos++) {//quantidade de avaliações
                    double nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota: " + pos));
                    disciplina.setNota(nota);
                    aluno.getDisciplinas().add(disciplina);
                }
                alunos.add(aluno);
            }

            maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
            maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
            maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

            for (Aluno aluno : alunos) {
                if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
                    maps.get(StatusAluno.APROVADO).add(aluno);
                } else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    maps.get(StatusAluno.RECUPERACAO).add(aluno);
                } else {
                    maps.get(StatusAluno.REPROVADO).add(aluno);
                }
            }

            System.out.println("----------Alunos Aprovados----------");
            for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Média do Aluno: " + aluno.getMediaNota() + "\n");
            }

            System.out.println("----------Alunos em Recuperação----------");
            for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Média do Aluno: " + aluno.getMediaNota() + "\n");
            }

            System.out.println("----------Alunos Reprovados----------");
            for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Média do Aluno: " + aluno.getMediaNota());
            }

            System.out.println(alunos);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }
}