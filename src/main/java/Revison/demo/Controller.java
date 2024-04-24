package Revison.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    List<Todo> todoList;

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo mytodo){
        todoList.add(mytodo);
        return "new todo added";
    }

    @GetMapping("todos")
    public List<Todo> getAllTodo(){
        return todoList;
    }
    @PutMapping("todo/id/{id}/status")
    public String setTodoStatusById(@PathVariable Integer id, @RequestParam boolean flag)
    {
        for(Todo todo : todoList)
        {
            if(todo.getTodoId().equals(id))
            {
                todo.setTodoStatus(flag);
                return "todo: "   + id  + "updated to " +  flag;
            }
        }

        return "Invalid id";
    }


    @DeleteMapping("todo/id/{id}")
    public String removeTodoById(@PathVariable Integer id)
    {
        for(Todo todo : todoList)
        {
            if(todo.getTodoId().equals(id))
            {
                todoList.remove(todo);
                return "todo: "   + id  + " removed";
            }
        }

        return "Invalid id";
    }

}
