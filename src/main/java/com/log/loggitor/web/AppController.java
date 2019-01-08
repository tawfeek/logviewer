package com.log.loggitor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.App;
import com.log.loggitor.repository.AppRepository;

@RestController
public class AppController {
	
	@Autowired
    private  AppRepository appRepository;

	@RequestMapping("/app")
    public Iterable<App> getApps() {

		return appRepository.findAll();
    } 
	


}
