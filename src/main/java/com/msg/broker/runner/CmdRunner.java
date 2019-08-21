package com.msg.broker.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.msg.broker.producer.Employee;
import com.msg.broker.producer.MsgProducer;

@Component
public class CmdRunner  implements CommandLineRunner{

	
	@Autowired
	private MsgProducer producer;
	
	@Override
	public void run(String... args) throws Exception {
		Employee emp=new Employee();
		emp.setEid(101);
		emp.setEname("Rituraj");
		emp.setEsal(40000.00);
		emp.setDeptLoc("California");
		
		
		if(producer.msgsending("this is msg with manual configuration")) {
		System.out.println("msg sends Sucess fully ...............");
		}
		else {
			System.out.println("msg not sent some error ocuured");
		}
	}
}