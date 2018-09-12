package filetransaction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOut {

	public static void main(String[] args) throws IOException {
		String text = "Hello World.";
		byte[] data = text.getBytes();
		OutputStream out = null;

		try{
			out = new FileOutputStream("Output.txt");
			out.write(data);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
			if(out!=null)out.close();
		}

	}

}
