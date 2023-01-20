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
        ToDo list = new ToDo(null, "Trabalhar", "Desenvolvimento do projeto To-Do List", LocalDateTime.parse("20/02/2023 13:00", formatter),false);
        ToDo list1 = new ToDo(null, "Correr", "Corrida matinal", LocalDateTime.parse("20/02/2023 06:00", formatter),true);
        ToDo list2 = new ToDo(null, "Almoço", "Fazer almoço para família", LocalDateTime.parse("20/02/2023 12:00", formatter),true);
        ToDo list3 = new ToDo(null, "Dormir", "Hora de descançar", LocalDateTime.parse("20/02/2023 23:00", formatter),false);


        repository.saveAll(Arrays.asList(toDo, list, list1, list2, list3));
    }
}
