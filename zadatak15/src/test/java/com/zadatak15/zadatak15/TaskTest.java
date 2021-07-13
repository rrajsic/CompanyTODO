package com.zadatak15.zadatak15;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

import DataLayer.Task;
import DataLayer.Task.taskStatus;
import DataLayer.Task.taskType;

public class TaskTest {
	@Test
	public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
	
	@Test
	public void shouldMakeADeepCopyOfTaskUsingClone() {
		Calendar cals = Calendar.getInstance();
		Date startdate=new Date();
		startdate.setDate(10);
		Date enddate=new Date();
		enddate.setDate(15);
		
		Task task1=new Task("Task1","New task", taskType.BUG, taskStatus.OPEN, 1, 1, startdate, enddate);	
		Task task2=new Task();
		task2 = SerializationUtils.clone(task1);
		Assert.assertEquals(task1.getId(), task2.getId());
		Assert.assertEquals(task1.getTitle(), task2.getTitle());
		Assert.assertEquals(task1.getDescription(), task2.getDescription());
		Assert.assertEquals(task1.getType(), task2.getType());
		Assert.assertEquals(task1.getStatus(), task2.getStatus());
		Assert.assertEquals(task1.getComplexity(), task2.getComplexity());
		Assert.assertEquals(task1.getTimespent(), task2.getTimespent());
		Assert.assertEquals(task1.getStartdate(), task2.getStartdate());
		Assert.assertEquals(task1.getEnddate(), task2.getEnddate());
		
	}

}
