package br.com.todo.project.eduardo.todolist.configuration;

import br.com.todo.project.eduardo.todolist.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration @Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    public Boolean instancia() {
        this.dbService.intanciaBaseDeDados();
        return true;
    }
}
