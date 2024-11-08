package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	
	
	@DataProvider(name="Data")
	public String[][]getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//ApiTestData.xlsx";
		
	Utility util=new Utility(path);
	int rownum=	util.getRowCount("Sheet1");
	int colcount=util.getCellCount("Sheet1",1);
		
		
		
		String apidata[][]=new String [rownum][colcount];
		
		
		for(int i=1;i<=rownum;i++) 
		{
			
			
		for(int j=0;j<colcount;j++)
		{
			
			
			
			apidata[i-1][j]=util.getCellData("Sheet1",i,j);

			
		}
			
			
		}
		
		return apidata;
		
		
		
		
		
		
		
	}
	
	
	
	

@DataProvider(name="UserNames")	
public String[]getUsernames() throws IOException
{
	
	
	
	
	
	String path=System.getProperty("user.dir")+"//TestData//ApiTestData.xlsx";		
	
		
	Utility util=new Utility(path);
	int rownum=	util.getRowCount("Sheet1");
	//int colcount=util.getCellCount("Sheet1", 1);
		
		
		
		String apidata[]=new String [rownum];
		
		
		for(int i=1;i<=rownum;i++) 
		{
			
			
			
			
	apidata[i-1]=util.getCellData("Sheet1",i,1);

			
		}
			
			
		
		
		return apidata;
		
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
}
