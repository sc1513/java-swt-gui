package fileRetrieve;

//Import java support
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//Import apache POI Classes
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Import ProuctList Class
import itemlist.ProductList;


public class FileGet {
	
	// Create an int variable called totalItems, this is used to later in the main program to determine total amount of rows needed in the
	//SWT table.
	public static int totalItems = 0;
	public static ProductList[] getfile(String fname) throws IOException {
		
		// Create an Object called item from the ProductList array.
		int numItems = 200;
		ProductList [] item = new ProductList [numItems];
		
		// Create File object the parameter take a string that has the file path of the file you are trying to find.
		File src = new File("C:\\Users\\Steven Carpenter\\Desktop\\" + fname + ".xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		totalItems = sheet1.getPhysicalNumberOfRows();
		// Create an array of objects and then add data to the list.
		
		int j = 0;
		String data = "no data";
		
		// Create for top to fill the values of the ProductList class.
		for (int i = 0 ; i < totalItems; i++) {
			
				data = sheet1.getRow(i).getCell(j++).getStringCellValue();
				item[i] = new ProductList();
				item[i].setUPC(data);
				data = sheet1.getRow(i).getCell(j++).getStringCellValue();
				item[i].setStyle(data);
				data = sheet1.getRow(i).getCell(j++).getStringCellValue();
				item[i].setDescription(data);
				data = sheet1.getRow(i).getCell(j++).getStringCellValue();
				item[i].setColor(data);
				data = sheet1.getRow(i).getCell(j++).getStringCellValue();
				item[i].setSize(data);
				j = 0;
		}
		
		wb.close();
		
		// Return the reference of the ProductList.
		return item;

	}
	// Return total items to get total amount of rows.
	public static int getRowNum() {
		
		return totalItems;
	}
	
	
}
