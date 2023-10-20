package service;

import entity.Tarefa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;


@Service
public class TarefaService {
    private List<Tarefa> tarefas;

    public TarefaService(){
        tarefas = new ArrayList<>();
    }
    //Listar Tarefas:
    public List<Tarefa> buscarTarefas() {
        return tarefas;
    }

    //Consultar detalhes Tarefa
    public Optional<Tarefa> consultarTarefa(int codigo) throws Exception {
        Optional<Tarefa> tarefa = tarefas.stream().filter
                (e -> e.getCodigoTarefa() == codigo).findFirst();
        if(tarefa.isPresent()){
            return tarefa;
        } else {
            throw new Exception("Pedido não encontrado!");
        }
    }

    //Adicionar Tarefa:
    public Tarefa criarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        return tarefa;
    }

    //Atualizar Tarefa:

    public Tarefa atualizarTarefa(Int codigo) throws Exception {
        Optional<Tarefa> tarefaDaBase = tarefas.stream().filter
                (e -> e.getCodigoTarefa() == codigo).findFirst();
        if(tarefaDaBase.isPresent()){
            pedidoDaBase.get().setNomeTarefa(tarefa.setNomeTarefa());
            pedidoDaBase.get().setStatusTarefa(tarefa.setStatusTarefa());
            return tarefa;
        } else {
            throw new Exception("Tarefa não encontrado!");
        }
    }

    //Atualizar Status Tarefa
    public Tarefa atualizarStatusTarefa(Int codigo) throws Exception {
        Optional<Tarefa> tarefaDaBase = tarefas.stream().filter
                (e -> e.getCodigoTarefa() == codigo).findFirst();
        if(tarefaDaBase.isPresent()){
            pedidoDaBase.get().setStatusTarefa(tarefa.setStatusTarefa());
            return tarefa;
        } else {
            throw new Exception("Tarefa não encontrado!");
        }
    }

    //Remover Tarefa:
    public void removerTarefa(Int codigo) {
        tarefas.removeIf(tarefa -> tarefa.getCodigoTarefa() == codigo);
    }

}
