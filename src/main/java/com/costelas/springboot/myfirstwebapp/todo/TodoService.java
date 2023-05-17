package com.costelas.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "costelas", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "costelas", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "costelas", "Learn FullStack",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description,targetDate,done);
        todos.add(todo);
    }

    public void deleteById(long id) {
        // todo.getId() == id
        // todo -> todo.getId() == id
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
}
