package com.task.controller.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.task.model.Address1;
import com.task.model.Employee1;
import com.task.repository.AddressRepo;
import com.task.repository.ResponseRepo;

@Service
public class IdGeneration {
	@Autowired
	AddressRepo AddressRepo;
	@Autowired
	ResponseRepo ResponseRepo;
	@Transactional(isolation = Isolation.SERIALIZABLE,timeout = 1000,readOnly = true)
	public synchronized Integer empidgeneration()
	{
		ReentrantLock r=new ReentrantLock(true);
		r.lock();
		List<Employee1> findAll = ResponseRepo.findAll();
		r.unlock();
		return findAll.size()+1;
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE,timeout = 1000,readOnly = true)
	public synchronized Integer Addressidgeneration()
	{
		ReentrantLock r=new ReentrantLock(true);
		r.lock();
		List<Address1> findAll = AddressRepo.findAll();
		r.unlock();
		return findAll.size()+1;
	}
	
	
}
