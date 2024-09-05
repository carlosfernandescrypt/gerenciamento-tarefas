package br.com.gerenciamento.controller;

import br.com.gerenciamento.repository.TarefaRepository;
import br.com.gerenciamento.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/inserirTarefas")
    public ModelAndView insertTarefas(Tarefa tarefa) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Tarefa/formTarefa");
        modelAndView.addObject("tarefa", new Tarefa());
        return modelAndView;
    }

    @PostMapping("InsertTarefas")
    public ModelAndView inserirTarefa(@Valid Tarefa tarefa, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("Tarefa/formTarefa");
            modelAndView.addObject("tarefa");
        } else {
        modelAndView.setViewName("redirect:/Tarefas-adicionados");
        tarefaRepository.save(tarefa);
        }
        return modelAndView;
    }

    @GetMapping("Tarefas-adicionados")
    public ModelAndView listagemTarefas() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Tarefa/listTarefas");
        modelAndView.addObject("TarefasList", tarefaRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id")Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Tarefa/editar");
        Tarefa tarefa = tarefaRepository.getById(id);
        modelAndView.addObject("tarefa", tarefa);
        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(Tarefa tarefa) {
        ModelAndView modelAndView = new ModelAndView();
        tarefaRepository.save(tarefa);
        modelAndView.setViewName("redirect:/Tarefas-adicionados");
        return modelAndView;
    }

    @GetMapping("/remover/{id}")
    public String removerTarefa(@PathVariable("id") Long id) {
        tarefaRepository.deleteById(id);
        return "redirect:/Tarefas-adicionados";
    }

    @GetMapping("filtro-Tarefas")
    public ModelAndView filtroTarefas() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Tarefa/filtroTarefas");
        return modelAndView;
    }

    @GetMapping("Tarefas-ativos")
    public ModelAndView listaTarefasAtivos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Tarefa/Tarefas-ativos");
        modelAndView.addObject("TarefasAtivos", tarefaRepository.findByStatusAtivo());
        return modelAndView;
    }

    @GetMapping("Tarefas-inativos")
    public ModelAndView listaTarefasInativos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Tarefa/Tarefas-inativos");
        modelAndView.addObject("TarefasInativos", tarefaRepository.findByStatusInativo());
        return modelAndView;
    }

    @PostMapping("/pesquisar-tarefa")
    public ModelAndView pesquisarTarefa(@RequestParam(required = false) String nome) {
        ModelAndView modelAndView = new ModelAndView();
        List<Tarefa> listaTarefas;
        if(nome == null || nome.trim().isEmpty()) {
            listaTarefas = tarefaRepository.findAll();
        } else {
            listaTarefas = tarefaRepository.findByNomeContainingIgnoreCase(nome);
        }
        modelAndView.addObject("ListaDeTarefas", listaTarefas);
        modelAndView.setViewName("Tarefa/pesquisa-resultado");
        return modelAndView;
    }
}
