package com.example.task.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_TASKS")
public class TaskModel implements Serializable {
    private  static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID idTask;
    @Column
    private String task;
    @Column
    private String responsible;
    @Column
    private String observation;

    public UUID getIdTask() {
        return idTask;
    }

    public String getTask() {
        return task;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getObservation() {
        return observation;
    }


    public void setIdTask(UUID idTask) {
        this.idTask = idTask;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
