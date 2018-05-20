package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testOfTaskMapperMethods() {
        // Given
        Task task = new Task(1L, "task 1", "content of task 1 ");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        // When
        TaskDto mappedTask= taskMapper.mapToTaskDto(task);
        List<TaskDto> mappdedList = taskMapper.mapToTaskDtoList(taskList);
        Task remappedTask = taskMapper.mapToTask(mappedTask);

        // Then
        Assert.assertEquals(task.getId(), remappedTask.getId());
        Assert.assertEquals(task.getTitle(), remappedTask.getTitle());
        Assert.assertEquals(task.getContent(), remappedTask.getContent());
        Assert.assertEquals(taskList.size(), mappdedList.size());
    }
}
