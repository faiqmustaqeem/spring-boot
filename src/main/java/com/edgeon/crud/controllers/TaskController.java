package com.edgeon.crud.controllers;


import com.edgeon.crud.models.TaskModel;
import com.edgeon.crud.repositories.TaskRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository)
    {
        this.taskRepository=taskRepository;
    }

    @ApiOperation("get ki api hay")
    @GetMapping("/all")
    public List<TaskModel> getAll()
    {
        List<TaskModel> tasks= this.taskRepository.findAll();
        return tasks;
    }

    @PostMapping
    public void insert(@RequestBody TaskModel taskModel)
    {
        this.taskRepository.save(taskModel);
    }





}
