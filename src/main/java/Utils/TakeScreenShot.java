package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import freeCRmAuto1.BaseClass;




public class TakeScreenShot extends  BaseClass
{

	public void takeSnap() {
		//int ranNum=(int) (Math.random()*999999+1000000);
		TakesScreenshot scrShot =(TakesScreenshot)driver;
	
		int i=0;
		File Sourcefile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./ScreenShots/img/"+i+".png");
		i++;
		try {
			FileUtils.copyFile(Sourcefile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return ranNum;
		
	}
		
		
	

}
