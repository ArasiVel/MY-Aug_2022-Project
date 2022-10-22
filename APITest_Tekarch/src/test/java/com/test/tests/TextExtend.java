package com.test.tests;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class TextExtend {
			
				public static ExtentHtmlReporter htmlReporter;
				public static ExtentReports extent;
				public static ExtentTest logger;

				public static void main(String[] args) {
					

					htmlReporter = new ExtentHtmlReporter("extentReports.html");
					extent = new ExtentReports();

					htmlReporter.config().setDocumentTitle("Test Execution Report");
					htmlReporter.config().setReportName("APITest_Tekarch");
					htmlReporter.config().setTheme(Theme.STANDARD);

					extent.attachReporter(htmlReporter);
					extent.setSystemInfo("Host Name", "Tekarch");
					extent.setSystemInfo("Environment", "Automation Testing");
					extent.setSystemInfo("User Name", "Arasi");

					logger = extent.createTest("test1");

					logger.log(Status.INFO, "info message");
					logger.log(Status.PASS, MarkupHelper.createLabel("test1" + "is passTest", ExtentColor.GREEN));
					logger.log(Status.FAIL, MarkupHelper.createLabel("test1" + "is not passTest", ExtentColor.RED));
					
					logger = extent.createTest("test2");

					logger.log(Status.INFO, "info message1");
					logger.log(Status.PASS, MarkupHelper.createLabel("test2" + "is passTest", ExtentColor.GREEN));
					logger.log(Status.FAIL, MarkupHelper.createLabel("test2" + "is not passTest", ExtentColor.RED));
					
					logger = extent.createTest("test3");

					logger.log(Status.INFO, "info message");
					logger.log(Status.PASS, MarkupHelper.createLabel("test3" + "is passTest", ExtentColor.GREEN));
					logger.log(Status.FAIL, MarkupHelper.createLabel("test3" + "is not passTest", ExtentColor.RED));
					
					logger = extent.createTest("test4");

					logger.log(Status.INFO, "info message");
					logger.log(Status.PASS, MarkupHelper.createLabel("test4" + "is passTest", ExtentColor.GREEN));
					logger.log(Status.FAIL, MarkupHelper.createLabel("test4" + "is not passTest", ExtentColor.RED));
					
					logger = extent.createTest("test5");

					logger.log(Status.INFO, "info message");
					logger.log(Status.PASS, MarkupHelper.createLabel("test5" + "is passTest", ExtentColor.GREEN));
					logger.log(Status.FAIL, MarkupHelper.createLabel("test5" + "is not passTest", ExtentColor.RED));
					
					extent.flush();
					System.out.println("completed");
				}

			
}
