package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TarefaService;

@RestController
@RequestMapping
public class TarefaController {

    Private final TarefaService tarefaService;

    Public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping("tarefas")
    public ResponseEntity<?> consultarTarefas(){
        try {
            List<Tarefa> lista =
                    tarefaService.consultarrTarefas();
            return new ResponseEntity(lista, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>
                    ("Erro na requisição",
                            HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> criarTarefa(@RequestBody Tarefa tarefa){
        try{
            tarefa = tarefaService.criarTarefa(tarefa);
            return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{codigoTarefa}")
    public ResponseEntity<?> consultarTarefa(@PathVariable("codigoTarefa") int codigo){
        try {
            Tarefa tarefa = tarefaService.consultarTarefa(codigo);
            return new ResponseEntity(tarefa, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("alterarTarefa/{codigoTarefa}")
    public ResponseEntity<?> atualizarTarefa(@RequestBody Tarefa tarefa, @PathVariable("codigoTarefa") int codigoTarefa){
        try{
            tarefa = tarefaService.atualizarTarefa(nomeTarefa, statusTarefa);
            return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("alterarStatusTarefa/{codigoTarefa}")
    public ResponseEntity<?> atualizarStatusTarefa(@RequestBody Tarefa tarefa, @PathVariable("codigoTarefa") int codigoTarefa){
        try{
            tarefa = tarefaService.atualizarTarefa(statusTarefa);
            return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("remover/{codigoTarefa}")
    public ResponseEntity<?> removerTarefa(@PathVariable("codigoTarefa") int codigoTarefa){
        try {
            produtoService.removerTarefa(codigo);
            return new ResponseEntity("Tarefa Removido com Sucesso", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
