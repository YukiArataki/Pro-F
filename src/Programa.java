import java.util.List;

import br.edu.up.controle.ControleAluno;
import br.edu.up.modelo.Aluno;
import br.edu.up.view.MainView;

public class Programa {
    public static void main(String[] args) {

        String arquivoAlunos = "alunos.csv";
        String arquivoRelatorio = "resumo.csv";

        ControleAluno controle = new ControleAluno();
        controle.carregarAlunos(arquivoAlunos);

        MainView view = new MainView();
        view.exibirRelatorio(controle, arquivoRelatorio);

    }
      
    }
