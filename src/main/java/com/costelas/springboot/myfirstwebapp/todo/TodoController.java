package com.costelas.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        // the todo from todo.jsp is mapped here;
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    // Map forms from todo.jsp to this todo
    // Validation here + Validation at todo + BindingResult
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }

        String username = (String) modelMap.get("name");
        LocalDate targetDate = todo.getTargetDate();
        todoService.addTodo(username, todo.getDescription(),
                targetDate, false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam long id) {
        //Delete todo
        todoService.deleteById(id);
        return "redirect:list-todos";
        // We implement the logic of deleting the todo in TodoService
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    // Map forms from todo.jsp to this todo
    // Validation here + Validation at todo + BindingResult
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String) modelMap.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam long id, ModelMap modelMap) {
        //Update todo
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo", todo);
        return "todo";
        // We implement the logic of updating the todo in TodoService
    }

}
