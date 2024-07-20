package br.com.todo_list.todo_list.service;

import br.com.todo_list.todo_list.entity.Todo;
import br.com.todo_list.todo_list.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    List<Todo> create(Todo todo){
        repository.save(todo);
        return list();
    }
    List<Todo> list(){
      Sort sort =  Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
      return repository.findAll();
    }
    List<Todo> update(Todo todo){
        repository.save(todo);
        return list();
    }
    List<Todo> delete(Long id){
        repository.deleteById(id);
        return list();
    }
}
