package br.com.turma;

import br.com.classe.Aluno;
import br.com.classe.Disciplina;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Qual o nome do aluno? ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do aluno? "));

        String nomeMateria = JOptionPane.showInputDialog("Qual a matéria? ");
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 1: "));
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 2: "));


        Aluno aluno1 = new Aluno();
        aluno1.setNome(nome);
        aluno1.setIdade(idade);

        Disciplina disciplina = new Disciplina();
        disciplina.setDisciplina(nomeMateria);
        disciplina.setNota(nota1);
        disciplina.setNota(nota2);
        aluno1.getDisciplinas().add(disciplina);



        System.out.println("Informações gerais: " + aluno1.toString());

        System.out.println("Nome: " + aluno1.getNome());
        System.out.println("Idade: " + aluno1.getIdade());
        System.out.println("Média do Aluno: " + aluno1.getMediaNota());
        System.out.println("Resultado: " + aluno1.getAlunoAprovado());


    }
}