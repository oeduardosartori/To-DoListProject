package br.com.todo.project.eduardo.todolist.resource;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping
    public ResponseEntity<List<ToDo>> listAll() {
        List<ToDo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ToDo> create(@RequestBody ToDo object) {
        object = service.create(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).body(object);
    }

}
