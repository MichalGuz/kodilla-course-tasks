package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(@RequestParam Long id){
        return taskMapper.mapToTaskDto(service.getTask(id));
    }

//    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
//    public List<TaskDto> getTasks(){
//        return new ArrayList<>();
//    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
//    public void deleteTask(String taskId){
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "getTask")
//    public TaskDto getTask(String taskId){
//        return new TaskDto((long)1, "test title", "test content");
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
//    public TaskDto updateTask(TaskDto taskDto){
//        return new TaskDto((long)2, "Edited test title", "Edited test content");
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "createTask")
//    public void createTask(TaskDto taskDto){
//    }
}
