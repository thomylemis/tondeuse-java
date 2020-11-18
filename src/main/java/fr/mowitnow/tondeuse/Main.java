package fr.mowitnow.tondeuse;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args !=null && args.length>0 && args[0]!=null && !args[0].trim().isEmpty()) {
			List<String> results= ReaderFile.readOneLine(args[0]);
			results.forEach(System.out::println);
		}
	}
}
