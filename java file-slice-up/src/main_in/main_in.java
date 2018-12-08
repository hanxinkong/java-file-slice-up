package main_in;

import in.in_file;

public class main_in {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Begin");

		in_file get = new in_file();

		String file = "D:\\SERVERS\\array.mp4";

		int count = 30;
		get.getsplit(file, count);

		System.out.println("Ok");
	}
}
