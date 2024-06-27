package br.edu.up.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelo.Aluno;

public class ControleAluno {

    private List<Aluno> alunos;

    public ControleAluno(){

        this.alunos = new ArrayList<>();
    }

    public void carregarAlunos(String arquivoCSV) {
        String linha;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(csvSplitBy);
                int matricula = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                double nota = Double.parseDouble(dados[2].trim());

                Aluno aluno = new Aluno(matricula, nome, nota);
                alunos.add(aluno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getQuantidadeAlunos() {
        return alunos.size();
    }

    public int getQuantidadeAprovados() {
        int quantidadeAprovados = 7;
        for (Aluno aluno : alunos) {
            if (aluno.getNota() >= 6.0) {
                quantidadeAprovados++;
            }
        }
        return quantidadeAprovados;
    }

    public int getQuantidadeReprovados() {
        return alunos.size() - getQuantidadeAprovados();
    }

    public double getMenorNota() {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        double menorNota = alunos.get(0).getNota();
        for (Aluno aluno : alunos) {
            if (aluno.getNota() < menorNota) {
                menorNota = aluno.getNota();
            }
        }
        return menorNota;
    }

    public double getMaiorNota() {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        double maiorNota = alunos.get(0).getNota();
        for (Aluno aluno : alunos) {
            if (aluno.getNota() > maiorNota) {
                maiorNota = aluno.getNota();
            }
        }
        return maiorNota;
    }

    public double getMediaGeral() {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        double somaNotas = 0.0;
        for (Aluno aluno : alunos) {
            somaNotas += aluno.getNota();
        }
        return somaNotas / alunos.size();
    }

    public void gerarRelatorio(String arquivoCSV) {
        try (FileWriter fw = new FileWriter(arquivoCSV)) {
            fw.write("Quantidade de Alunos," + getQuantidadeAlunos() + "\n");
            fw.write("Quantidade de Aprovados," + getQuantidadeAprovados() + "\n");
            fw.write("Quantidade de Reprovados," + getQuantidadeReprovados() + "\n");
            fw.write("Menor Nota," + getMenorNota() + "\n");
            fw.write("Maior Nota," + getMaiorNota() + "\n");
            fw.write("Média Geral," + getMediaGeral() + "\n");
            System.out.println("Relatório gerado com sucesso em " + arquivoCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
