package br.com.todo.project.eduardo.todolist.services;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private TodoRepository repository;

    public ToDo findById(Long id) {
        Optional<ToDo> object = repository.findById(id);
        return object.orElse(null);
    }
}
