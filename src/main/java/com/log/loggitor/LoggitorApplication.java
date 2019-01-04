package com.log.loggitor;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.log.loggitor.domain.App;
import com.log.loggitor.repository.AppRepository;
import com.log.loggitor.domain.DefectInstance;
import com.log.loggitor.domain.Defects;
import com.log.loggitor.domain.LogFile;
import com.log.loggitor.domain.Solutions;
import com.log.loggitor.readlogs.Line;
import com.log.loggitor.readlogs.LogReader;
import com.log.loggitor.readlogs.Logwriter;
import com.log.loggitor.repository.DefectInstanceRepository;
import com.log.loggitor.repository.DefectsRepository;
import com.log.loggitor.repository.LogFileRepository;
import com.log.loggitor.repository.SolutionsRepositroy;



@SpringBootApplication
public class LoggitorApplication {
	@Autowired
	private AppRepository repositoryAppTable;
	@Autowired
	private DefectInstanceRepository repDefectInstanceTable;
	@Autowired
	private DefectsRepository repDefTable;
	
	@Autowired
	private SolutionsRepositroy repsolutionsTable;
	
	@Autowired
	private LogFileRepository repLogfileTable;
	
	static ArrayList<Line> LinesList ;
	private static final Logger logger=LoggerFactory.getLogger(LoggitorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LoggitorApplication.class, args);
		
		
		
		
		//check
		logger.info("Hi Tawfeek!!!!!");
	}
	@Bean
	CommandLineRunner runner() {
		return args-> {
			
			ArrayList<Line> LinesList2 = getLogsError();
			//repDefectInstanceTable.deleteAll();
			
			
			DefectInstance defectInstance1 = new DefectInstance(841,847,850);
			DefectInstance defectInstance2 = new DefectInstance(842,848,850);
			DefectInstance defectInstance3 = new DefectInstance(842,849,850);
			DefectInstance defectInstance4 = new DefectInstance(843,848,850);
			DefectInstance defectInstance5 = new DefectInstance(843,847,850);
			DefectInstance defectInstance6 = new DefectInstance(843,847,850);
			
			repDefectInstanceTable.save(defectInstance1);
			repDefectInstanceTable.save(defectInstance2);
			repDefectInstanceTable.save(defectInstance3);
			repDefectInstanceTable.save(defectInstance4);
			repDefectInstanceTable.save(defectInstance5);
			repDefectInstanceTable.save(defectInstance6);
			
			/*
			
			repDefectInstanceTable.save(defectInstance1);
			Date date = Calendar.getInstance().getTime();
			LogFile log1 = new LogFile("log1", date);
			repLogfileTable.save(log1);
			
			
			
			
		
			repDefTable.deleteAll();
			
			Defects defects1 = new Defects("Warning", "000004",844);
			Defects defects2 = new Defects("Error", "000005",845);
			Defects defects3 = new Defects("Warning", "000006",846);
			repDefTable.save(defects1);
			repDefTable.save(defects2);
			repDefTable.save(defects3);
			*/
			
			
			//repositoryAppTable.deleteAll();
			//repsolutionsTable.deleteAll();
			
			
			
			//App app1=new App("BLM2","Custom");
		//	App app2=new App("BLM1","Core");
		//	App app3=new App("BLM3","Custom");
			
		//	repositoryAppTable.save(app1);
		//	repositoryAppTable.save(app2);
		//	repositoryAppTable.save(app3);
			
		//	Solutions sol1 = new Solutions("sol1","sol1 is very good");
		//	Solutions sol2 = new Solutions("sol2","sol2 is very bad");
		//	Solutions sol3 = new Solutions("sol3","sol3 is not enough");
			
		//	repsolutionsTable.save(sol1);
		//	repsolutionsTable.save(sol2);
		//	repsolutionsTable.save(sol3);
			/*
			for(Line b:LinesList2) {
			App app=new App(b.getApplicationName(),b.getApplicationType());
			repositoryAppTable.save(app);
			
			Defects defects = new Defects(b.getSolution(), b.getSeverity(), b.getErrorCode());
			repDefTable.save(defects);
			
			
			App app1=new App("aaa","Custom");
			App app2=new App("bbb","Core");
			App app3=new App("ccc","Custom");
			
			}
			
		
			App app1=new App("aaa","Custom");
			App app2=new App("bbb","Core");
			App app3=new App("ccc","Custom");
		repository1.save(app1);
		repository1.save(app2);
		repository1.save(app3);
		repository1.save(app4);
		rep.save(new DefectInstance(1,1,1,app1));
		rep.save(new DefectInstance(5,2,2,app2));
		rep.save(new DefectInstance(3,3,3,app3));
		repDef.save(new Defects("Critical", "00004", "ssss"));
		repDef.save(new Defects("Warning", "00036", "zzzz"));
		repDef.save(new Defects("Error", "00001", "aaaa"));
		
		*/
		};
	}
	
	
	public static ArrayList<Line> getLogsError(){

		//String fileName = "D:\\fullstuckCourse\\logsProject\\hasErrors\\CMServer.20170914_2028.log";
				String fileToWrite =  "D:\\fullstuckCourse\\logsProject\\hasErrors\\outPut.txt";
				String fileName = "D:\\fullstuckCourse\\logsProject\\fromMohamad\\CMServer.20170914_2028.log";
				LogReader logReader = new LogReader(fileName);
				logReader.getAllLines();
				
				Logwriter logwriter = new Logwriter(fileToWrite, logReader.getLinesList());
		
				logwriter.numberOfErrorsPerApp();
				logwriter.numberOfErrorsPerErrorCode();
				logwriter.numberOfErrorsPerSeverity();
				logwriter.numberOfErrorsPerAppSeverity();
				
				LinesList = logReader.getLinesList();
				System.out.println("get application name: "+LinesList.get(0).getApplicationName());
		return LinesList;
	}
	

}

