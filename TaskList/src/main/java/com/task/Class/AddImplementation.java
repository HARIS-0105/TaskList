package com.task.Class;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class AddImplementation {

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
//		TreeMap<String,Set<String>> taskMap=new TreeMap<>();
//		FileInterface.WriteTreeIntoDetails(taskMap);
//		HashSet<String> historySet=new HashSet<>();
//		FileInterface.WriteSetIntoHistory(historySet);
		//hs.clear();
		TreeMap<String,Set<String>> taskMapFile=FileInterface.getTreeFromDetails();
		System.out.println(taskMapFile);
		HashSet<String>historySetOut=FileInterface.getSetFromHistory();
		System.out.println(historySetOut);
	}

}
