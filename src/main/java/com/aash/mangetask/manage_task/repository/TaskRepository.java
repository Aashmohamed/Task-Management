package com.aash.mangetask.manage_task.repository;

import com.aash.mangetask.manage_task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByActive(boolean b);

}
