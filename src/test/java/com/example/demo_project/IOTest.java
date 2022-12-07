package com.example.demo_project;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IOTest {
	@Test
	public void fileOutputStreamTest3() throws IOException {
	// try-with-resource
		try (FileOutputStream fos = new FileOutputStream("test01.txt", true)) {
			String str = "Hi!";
			fos.write('\n');
			fos.write(str.getBytes());
			System.out.println("Output successfully.");
		} catch (Exception e) {

		}

	}
	
	@Test
	public void bufferFileOutputStreamTest() throws IOException {
		// try-with-resource
		try (FileOutputStream fos = new FileOutputStream("test02.txt");
				BufferedOutputStream bfos = new BufferedOutputStream(fos)) {
			String str = "Hello world. This is test02.";
			bfos.write(str.getBytes());
			bfos.flush();
			System.out.println("Output successfully.");
		} catch (Exception e) {

		}

	}



	@Test
	public void fileInputStreamTest3() throws IOException {
		// try-with-resource
		try (FileInputStream fis = new FileInputStream("testIMG.jpeg")) {
			System.out.println("--> 1 File size: " + fis.available());
			byte[] b = fis.readAllBytes();
			System.out.println("--> 2 File size: " + fis.available());
			System.out.println("Input successfully.");
		} catch (Exception e) {

		}
	}

	@Test
	public void fileInputOutputStreamTest2() throws IOException {
		// try-with-resource
		try (FileInputStream fis = new FileInputStream("testIMG.jpeg");
				FileOutputStream fos = new FileOutputStream("testIMG2.jpeg")) {
//			System.out.println(b);
			System.out.println("File size: " + fis.available());
			byte[] b = fis.readAllBytes();
			fos.write(b);
			System.out.println("Input successfully.");
		} catch (Exception e) {

		}
	}

	@Test
	public void fileInputStreamTest() throws IOException {
		// try-with-resource
		try (FileInputStream fis = new FileInputStream("test01.txt")) {
			int b = fis.read();
			System.out.println(b);
			System.out.println((char) b);
			System.out.println("Input successfully.");
		} catch (Exception e) {

		}
	}

	@Test
	public void fileOutputStreamTest() throws IOException {
//		FileOutputStream fos = new FileOutputStream("test01.txt");
//
//		try {
//			fos.write(70);
//			System.out.println("Output successfully.");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			fos.close();
//		}

		// try-with-resource
		try (FileOutputStream fos = new FileOutputStream("test01.txt")) {
			String str = "Hello world.";
			fos.write(str.getBytes());
			System.out.println("Output successfully.");
		} catch (Exception e) {

		}

	}
}
