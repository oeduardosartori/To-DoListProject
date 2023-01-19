package br.com.todo.project.eduardo.todolist.services;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository repository;

    public void intanciaBaseDeDados() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        ToDo toDo = new ToDo(null, "Estudar", "Programação", LocalDateTime.parse("23/02/2023 10:30", formatter), false);

        repository.saveAll(Arrays.asList(toDo));
    }
}
