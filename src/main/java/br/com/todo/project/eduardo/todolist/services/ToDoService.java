package br.com.todo.project.eduardo.todolist.services;

import br.com.todo.project.eduardo.todolist.domain.ToDo;
import br.com.todo.project.eduardo.todolist.repository.TodoRepository;
import br.com.todo.project.eduardo.todolist.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private TodoRepository repository;

    public ToDo findById(Long id) {
        Optional<ToDo> object = repository.findById(id);
        return object.orElseThrow(() -> new NotFoundException(
                "Objeto não econtrado! Id:  " + id + ", Tipo: " + ToDo.class.getName()));
    }

    public List<ToDo> findAllOpen() {
        List<ToDo> list = repository.findAllOpen();
        return list;
    }

    public List<ToDo> findAllClose() {
        List<ToDo> list = repository.findAllClose();
        return list;
    }

    public List<ToDo> findAll() {
        List<ToDo> list = repository.findAll();
        return list;
    }

    public ToDo create(ToDo object) {
        object.setId(null);
        return repository.save(object);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
