package br.com.todo.project.eduardo.todolist.resource;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping(value = "/todos")
public class TodoResource {

    @Autowired
    private ToDoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Long id) {
        ToDo object = service.findById(id);
        return ResponseEntity.ok().body(object);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<ToDo>> listOpen() {
        List<ToDo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<ToDo>> listClose() {
        List<ToDo> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

}
