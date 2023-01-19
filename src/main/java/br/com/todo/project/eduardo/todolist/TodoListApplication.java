package br.com.todo.project.eduardo.todolist;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		ToDo toDo = new ToDo(null, "Estudar", "Programação", LocalDateTime.parse("23/02/2023 10:30", formatter), false);

		repository.saveAll(Arrays.asList(toDo));
	}
}
