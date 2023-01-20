package br.com.todo.project.eduardo.todolist.repository;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {

    @Query("SELECT obj FROM ToDo obj WHERE obj.finalizado = false ORDER BY obj.dataFinal")
    List<ToDo> findAllOpen();

    @Query("SELECT obj FROM ToDo obj WHERE obj.finalizado = true ORDER BY obj.dataFinal")
    List<ToDo> findAllClose();
}
