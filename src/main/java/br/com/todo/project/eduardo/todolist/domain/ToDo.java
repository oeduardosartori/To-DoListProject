package br.com.todo.project.eduardo.todolist.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "todolist")
@Entity(name = "TodoList")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ToDo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataFinal;
    private Boolean finalizado = false;

}
