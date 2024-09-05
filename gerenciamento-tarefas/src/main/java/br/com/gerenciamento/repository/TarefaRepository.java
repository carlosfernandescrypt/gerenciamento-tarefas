package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT a FROM Tarefa a WHERE a.status = 'PENDENTE' ")
    public List<Tarefa> findByStatusAtivo();

    @Query("SELECT i FROM Tarefa i WHERE i.status = 'CONCLUIDO' ")
    public List<Tarefa> findByStatusInativo();

    public List<Tarefa> findByNomeContainingIgnoreCase(String nome);

}
