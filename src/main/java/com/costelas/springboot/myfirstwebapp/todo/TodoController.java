package com.costelas.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUsername("costelas");
        modelMap.put("todos", todos);

        return "listTodos";
    }

    // GET, POST
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap) {
        String username = (String)modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        // the todo from todo.jsp is mapped here;
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    // Map forms from todo.jsp to this todo
    public String addNewTodo(ModelMap modelMap, Todo todo) {
        String username = (String)modelMap.get("name");
        todoService.addTodo(username,todo.getDescription(),
                LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }

}
