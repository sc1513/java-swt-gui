package project3;

import java.io.IOException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import fileRetrieve.FileGet;
import itemlist.ProductList;
import org.eclipse.wb.swt.SWTResourceManager;

//Import all necessary SWT classes
//Import fileRetrieve class, a class that I created to find and download files it also has all of the necessary Apache POI Imports
//Import the ProductList class, a class that I created to store product information.

public class windowapp {
	
	//Create variables, text labels, table and table column arrays.
	private static Text text;
	private static Table table;
	private static Text text_1;
	public static TableItem [] cell;
	public static TableItem [] cell1;
	public static int rowNum;
	public static int totalItemsFound;
	/**
	 * Launch the application.
	 * @param args
	 */

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlItemChecklistApplication = new Shell();
		shlItemChecklistApplication.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		shlItemChecklistApplication.setSize(1232, 805);
		shlItemChecklistApplication.setText("Item Checklist Application");
		
	//Create Label	
		Label label = new Label(shlItemChecklistApplication, SWT.BORDER);
		label.setSize(200,44);
		label.setLocation(464, 265);
		label.setText("File Name");
		
	//Create Label
		Label lblEnterTheFile = new Label(shlItemChecklistApplication, SWT.BORDER);
		lblEnterTheFile.setSize(368,44);
		lblEnterTheFile.setLocation(34, 124);
		lblEnterTheFile.setText("Enter the file name without extention: ");
		
	//Create Table
		table = new Table(shlItemChecklistApplication, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(464, 324, 704, 347);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
	//Create Table Columns
		TableColumn tcolumn = new TableColumn(table, 1);
		TableColumn tcolumn2 = new TableColumn(table, 1);
		TableColumn tcolumn3 = new TableColumn(table, 1);
		TableColumn tcolumn4 = new TableColumn(table, 1);
		TableColumn tcolumn5 = new TableColumn(table, 1);
		TableColumn tcolumn6 = new TableColumn(table, 1);
		
		tcolumn.setWidth(90);
		tcolumn2.setWidth(90);
		tcolumn3.setWidth(200);
		tcolumn4.setWidth(90);
		tcolumn5.setWidth(90);
		tcolumn6.setWidth(140);
		
		
		tcolumn.setText("UPC");
		tcolumn2.setText("Style");
		tcolumn3.setText("Description");
		tcolumn4.setText("Color");
		tcolumn5.setText("Size");
		tcolumn6.setText("Item Found");
		
	//Create label for Image
		Label label2 = new Label(shlItemChecklistApplication, SWT.BORDER);
		label2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label2.setSize(300,312);
		label2.setLocation(34, 359);
		label2.setImage(SWTResourceManager.getImage("C:\\Users\\Steven Carpenter\\GoldHead.gif"));
		
		
		Button btnNewButton = new Button(shlItemChecklistApplication, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				table.removeAll();
				String Fname = text.getText(); 
				lblEnterTheFile.setText("Currently on the file: " + Fname);
				label.setText(Fname);
				//Create item from the ProductList class.
				ProductList [] item;
				//Create F from the FileGet class.
				FileGet F = new FileGet();
				//Setup a try catch statement this is in the event object returns a null
				try {
					//Use F object from the FileGet class to retrieve a reference to a ProductLists array reference and then store that reference in 
					//an item object.
					rowNum = 0; // Set to zero in the event a different file is pulled.
					item = F.getfile(Fname);
					rowNum = F.getRowNum();
					cell = new TableItem [rowNum];
				int j = 0;
					for (int i = 0; i < rowNum; i++) {
						
						cell[i] = new TableItem(table, SWT.NONE);
						cell[i].setText(j++, item[i].getUPC());
						cell[i].setText(j++, item[i].getStyle());
						cell[i].setText(j++, item[i].getDescription());
						cell[i].setText(j++, item[i].getColor());
						cell[i].setText(j++, item[i].getSize());
						cell[i].setText(j++, item[i].getitemFound());
						j = 0;
		
					}
		
				} catch (IOException e1) {

					e1.printStackTrace();
					lblEnterTheFile.setText("Could not find file, Please try again.");
					label.setText("Not Found");
				}
				
			}
		});
		
		//Button to find file
		btnNewButton.setBounds(88, 221, 105, 35);
		btnNewButton.setText("Find File");
		
		//test box
		text = new Text(shlItemChecklistApplication, SWT.BORDER);
		text.setBounds(34, 180, 241, 35);
		
		//create label
		Label label1 = new Label(shlItemChecklistApplication, SWT.NONE);
		label1.setBounds(464, 59, -756, 83);
		
		//create label
		Label lblNewLabel = new Label(shlItemChecklistApplication, SWT.NONE);
		lblNewLabel.setBounds(464, 125, 368, 44);
		lblNewLabel.setText("Enter UPC:");
		
		//create text box
		text_1 = new Text(shlItemChecklistApplication, SWT.BORDER);
		text_1.setBounds(464, 180, 368, 35);
		
		//create button
		Button btnNewButton_1 = new Button(shlItemChecklistApplication, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			//create button event
			@Override
			public void mouseDown(MouseEvent e) {
				//create for loop to search through table
				String UPC1 = text_1.getText();
				for (int i = 0; i < cell.length; i++) {
					if(UPC1.equals(cell[i].getText(0))) {
						cell[i].setText(5, "Item Found");
					}
					
				}
			}
		});
		btnNewButton_1.setBounds(861, 180, 170, 35);
		btnNewButton_1.setText("Find UPC");		
		
		Button btnNewButton_2 = new Button(shlItemChecklistApplication, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				ProductList [] itemReplace = new ProductList[200];
				int c = 0;
				for (int i = 0; i < cell.length; i++) {
					if(!cell[i].getText(5).contentEquals("Item Found")) {
						
						itemReplace[c] = new ProductList();
						itemReplace[c].setUPC(cell[i].getText(0)); 
						itemReplace[c].setStyle(cell[i].getText(1)); 
						itemReplace[c].setDescription(cell[i].getText(2)); 
						itemReplace[c].setColor(cell[i].getText(3)); 
						itemReplace[c].setSize(cell[i].getText(4)); 
						itemReplace[c].setitemFound(cell[i].getText(5)); 
						c++;
					} else {
						totalItemsFound++;
					}
				}
				
				table.removeAll();
				rowNum -= totalItemsFound; // change the amount of rows in the table by the amount of items found.
				cell1 = new TableItem[rowNum];
				System.out.println(itemReplace[0].getUPC());
				int j = 0;
				for (int i = 0; i < rowNum; i++) {
					cell1[i] = new TableItem(table, SWT.NONE);
					cell1[i].setText(0, itemReplace[i].getUPC());
					cell1[i].setText(1, itemReplace[i].getStyle());
					cell1[i].setText(2, itemReplace[i].getDescription());
					cell1[i].setText(3, itemReplace[i].getColor());
					cell1[i].setText(4, itemReplace[i].getSize());
					cell1[i].setText(5, itemReplace[i].getitemFound());
					System.out.println(itemReplace[i].getUPC());
				}
				
			}
		});
		btnNewButton_2.setBounds(684, 274, 170, 35);
		btnNewButton_2.setText("Item Found Filter");

		//close application
		shlItemChecklistApplication.open();
		shlItemChecklistApplication.layout();
		while (!shlItemChecklistApplication.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
