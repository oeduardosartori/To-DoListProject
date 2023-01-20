package br.com.todo.project.eduardo.todolist.repository;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {

    @Query("SELECT obj FROM TodoList obj WHERE obj.finalizado = 0 ORDER BY obj.dataFinal")
    List<ToDo> findAllOpen();

    @Query("SELECT obj FROM TodoList obj WHERE obj.finalizado = 1 ORDER BY obj.dataFinal")
    List<ToDo> findAllClose();
}
