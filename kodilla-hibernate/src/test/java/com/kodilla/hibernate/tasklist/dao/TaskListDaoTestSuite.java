package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Test List", "List for unit testing");
        taskListDao.save(taskList);

        // When
        List<TaskList> retrievedList = taskListDao.findByListName("Test List");

        // Then
        assertEquals(1, retrievedList.size());
        assertEquals("Test List", retrievedList.get(0).getListName());

        // Cleanup
        taskListDao.deleteAll(retrievedList);
    }
}
