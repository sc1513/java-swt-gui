# java-swt-gui
The program checks inventory from a list uploaded from Excel using Apache POI. The program can upload an excel file, which is then
displayed on the GUI. After that the user can scan in barcodes or type in SKU numbers to find products on the list and mark them as found.
This process is meant to help find transfers and markdowns for retail companies.


In order for the program to work you will need to download the SWT plugins and download the Apache POI jars.
Apache POI Jars will need to be added to the class path.

This Program uses Apache POI and SWT. Apache POI down loads for eclipse can be found at https://poi.apache.org. Standard Widgets Toolkit
or SWT is the gui, the down load can be found at https://www.eclipse.org/swt. The Apache Poi plug in allows the application to parse 
through an excel file and pull the necessary strings from the document. The user can type in a document name above the find file button. 
I have the file path set to the desktop and the extension is xlsx. Typing in a string into the field will allow the program to concatenate 
the file path with the file name to to the file extension. After the file is found, the application uses Apache POI to parse through the 
document and save each row to a object stored in an array. After that the array of objects is used to fill the table in the application
using a linear algorithm. This application is mainly meant to be used as a checklist.

![Alt text](/sc1513/java-swt-gui/blob/master/Item%20checkout%20application.png?raw=true "Application")
