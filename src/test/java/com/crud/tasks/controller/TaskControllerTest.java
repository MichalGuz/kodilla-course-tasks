package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import com.sun.javafx.scene.control.skin.TableCellSkin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.image.DataBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    private Object Answer;

    @Test
    public void testGetTasks() throws Exception {
        // Given
//        taskMapper.mapToTaskDtoList(service.getAllTasks()
        List<TaskDto> tasks = new ArrayList<>();
        tasks.add(new TaskDto(1L, "1", "content 1"));
//        when(service.getAllTasks()).thenReturn(null);
        when(taskMapper.mapToTaskDtoList(any())).thenReturn(tasks);

        // When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(200))
        .andExpect(jsonPath("$",hasSize(1)));
    }

    @Test
    public void testGetTask() throws Exception {
        // Given
//        taskMapper.mapToTaskDto(service.getTask(id)
        Optional<Task> task = Optional.ofNullable(new Task(1L, "1", "content"));
        when(service.getTask(1L)).thenReturn(task);
//        TaskDto taskDto = new TaskDto (1L, "1", "content");
        when(taskMapper.mapToTaskDto(any())).thenReturn(new TaskDto (1L, "1", "content"));

        // When & Then
        mockMvc.perform(get("/v1/task/getTask").param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // Task fields
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.title",is("1")))
                .andExpect(jsonPath("$.content",is("content")));
    }
////
    @Test
    public void testUpdateTask() throws Exception{
        // Given
//        taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)))
        Task task = new Task (1L, "1", "content");
        Task updatedTask = new Task(1L, "1", "content");
        TaskDto updatedTaskDto = new TaskDto(1L, "1", "content");
        when(taskMapper.mapToTask(any())).thenReturn(task);
        when(service.saveTask(task)).thenReturn(updatedTask);
        when(taskMapper.mapToTaskDto(updatedTask)).thenReturn(updatedTaskDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(task);


//        // When & Then
        mockMvc.perform(put("/v1/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                // Task fields
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.title",is("1")))
                .andExpect(jsonPath("$.content",is("content")));
    }

    @Test
    public void testCreateTask() throws Exception {
//        // Given
//    service.saveTask(taskMapper.mapToTask(taskDto)
        TaskDto taskDto = new TaskDto (1L, "1", "content");
        Task task = new Task(1L, "1", "content");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(service.saveTask(task)).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(task);

        // When & Then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteTask() throws Exception {
        //Given
        //service.deleteTask(id)
        Task task = new Task(1L, "1", "content");
        service.deleteTask(any());

        Gson gson = new Gson();
        String jsonContent = gson.toJson(task);

        mockMvc.perform(delete("/v1/task/deleteTask").param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}