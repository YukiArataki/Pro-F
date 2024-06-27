package br.edu.up.view;

import java.util.List;

import br.edu.up.controle.ControleAluno;
import br.edu.up.modelo.Aluno;

public class MainView {

    public void exibirRelatorio(ControleAluno controller, String arquivoCSV) {
        controller.gerarRelatorio(arquivoCSV);
}

}
