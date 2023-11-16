/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAWOUD
 */


import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
public class DownloadFile {
    
    
    
    
    //start
    



        public static void main(String[] args) {
                URL url; //represents the location of the file we want to dl.
                URLConnection con;  // represents a connection to the url we want to dl.
                DataInputStream dis;  // input stream that will read data from the file.
                FileOutputStream fos; //used to write data from inut stream to file.
                byte[] fileData;  //byte aray used to hold data from downloaded file.
                try {
                        //url = new URL("http://icanhascheezburger.files.wordpress.com/2010/06/funny-pictures-cat-is-creepy.jpg");
                        url = new URL("http://software-files-a.cnet.com/s/software/10/79/45/50/cbsidlm-tr1_7-StepEditor-ORG2-10794551.exe?token=1352675984_77f959054aa0daca56050f59cab54457&lop=link&ptype=3001&ontid=2316&siteId=4&edId=3&spi=eb45aa7f1736e78077737b079d1d01d8&pid=10794550&psid=10794551&isDlm=1&fileName=cbsidlm-tr1_7-StepEditor-ORG2-10794551.exe");
                        
                        // Start Modification
                        String FileName=url.getHost();
                        String FileName2=url.getQuery();        
                        String URLString;
                        URLString = JOptionPane.showInputDialog(null, "Please Enter The URL", "URL Message", 3);
                        if(URLString==null)System.exit(0);
                        
                        
                        // End modification
                        
                        con = url.openConnection(); // open the url connection.
                        dis = new DataInputStream(con.getInputStream()); // get a data stream from the url connection.
                        fileData = new byte[con.getContentLength()]; // determine how many byes the file size is and make array big enough to hold the data
                        for (int x = 0; x < fileData.length; x++) { // fill byte array with bytes from the data input stream
                                fileData[x] = dis.readByte();
                        }
                        dis.close(); // close the data input stream
                        
                        fos = new FileOutputStream(new File("c:\\"+FileName2));  //create an object representing the file we want to save
                        fos.write(fileData);  // write out the file we want to save.
                        fos.close(); // close the output stream writer
                }
                catch(MalformedURLException m) {
                        System.out.println(m);
                }
                catch(IOException io) {
                        System.out.println(io);
                }
        }



//Read more: http://forum.codecall.net/topic/56943-java-download-files-from-the-web/#ixzz2Bc05ssXO

    
    //end
    
    
}
