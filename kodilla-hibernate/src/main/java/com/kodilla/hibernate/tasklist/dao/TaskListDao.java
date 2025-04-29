package com.kodilla.hibernate.tasklist.dao;

//import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.task.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskListDao extends CrudRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);
}

