package com.crud.tasks.covering;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTasks(){
        // Given
        List<Task> list = new ArrayList<>();
        Task task = new Task(1L, "task 1", "task description");

        // When
        List<Task> lists = dbService.getAllTasks();
        Task savedTask = dbService.saveTask(task);
        Optional<Task> foundedTask = dbService.getTask(1L);

        // Then
        Assert.assertEquals(list.size(), lists.size());
        Assert.assertTrue(task != savedTask);
        Assert.assertEquals(null, foundedTask);
    }


}
