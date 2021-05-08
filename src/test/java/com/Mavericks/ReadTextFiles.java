package com.Mavericks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadTextFiles {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("./TextFIles/text1.txt"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream(new File("./TextFIles/text2.txt"));
		ObjectOutputStream oiso = new ObjectOutputStream(fos);
		if (ois.readLine() != null) {
			oiso.writeObject(ois.readLine());
		}
	}

}
