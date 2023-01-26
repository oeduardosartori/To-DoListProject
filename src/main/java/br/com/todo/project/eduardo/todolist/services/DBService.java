package br.com.todo.project.eduardo.todolist.services;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository repository;

    public void intanciaBaseDeDados() throws ParseException {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        ToDo toDo = new ToDo(null, "Estudar", "Programação", simpleDate.parse("23/02/2023"), false);
        ToDo list = new ToDo(null, "Trabalhar", "Desenvolvimento do projeto To-Do List", simpleDate.parse("20/02/2023"),false);
        ToDo list1 = new ToDo(null, "Correr", "Corrida matinal", simpleDate.parse("20/02/2023"),true);
        ToDo list2 = new ToDo(null, "Almoço", "Preparar almoço", simpleDate.parse("20/02/2023"),true);
        ToDo list3 = new ToDo(null, "Dormir", "Hora de descançar", simpleDate.parse("20/02/2023"),false);


        repository.saveAll(Arrays.asList(toDo, list, list1, list2, list3));
    }
}
