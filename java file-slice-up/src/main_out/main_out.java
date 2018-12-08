package main_out;

import out.out_file;

public class main_out {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out_file out = new out_file();

		System.out.println("Begin");

		String file_path = "D:\\SERVERS\\temp\\array.mp4";
		String tempfile = "D:\\SERVERS\\array.mp4";
		int count = 30;
		out.merge(file_path, tempfile, count);

		System.out.println("Ok");
	}
}
