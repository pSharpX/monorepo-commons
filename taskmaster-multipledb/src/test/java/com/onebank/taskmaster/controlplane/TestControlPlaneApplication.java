package com.onebank.taskmaster.controlplane;

import com.onebank.taskmaster.TaskMasterApplication;
import org.springframework.boot.SpringApplication;

public class TestControlPlaneApplication {

	public static void main(String[] args) {
		SpringApplication.from(TaskMasterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
