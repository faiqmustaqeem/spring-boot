package com.edgeon.crud.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tasks")
public class TaskModel {


    @Id
    String id;

    String taskName;


    public TaskModel() {
    }

    public TaskModel(String id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }




}
