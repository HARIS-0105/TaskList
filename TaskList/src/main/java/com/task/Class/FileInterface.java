package com.task.Class;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;


public class FileInterface
{
	public static TreeMap<String,Set<String>> getTreeFromDetails() throws IOException
	{
		FileInputStream fileInputDetails=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\TaskList\\Details.txt");
		ObjectInputStream objectInputDetails=new ObjectInputStream(fileInputDetails);
		TreeMap<String,Set<String>>TaskMap=new TreeMap<>();
		try
		{
			TaskMap=(TreeMap<String, Set<String>>) objectInputDetails.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objectInputDetails.close();
		return TaskMap;
	}
	public static void WriteTreeIntoDetails(TreeMap<String,Set<String>>tree) throws IOException
	{
		FileOutputStream fileOuptutDetails=new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\TaskList\\Details.txt");
		ObjectOutputStream objectOutputDetails=new ObjectOutputStream(fileOuptutDetails);
		objectOutputDetails.writeObject(tree);
		objectOutputDetails.close();
	}
	public static void WriteSetIntoHistory(Set<String> set) throws IOException
	{
		FileOutputStream fileOutputHistory=new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\TaskList\\history.txt");
		ObjectOutputStream objectOutputHistory=new ObjectOutputStream(fileOutputHistory);
		objectOutputHistory.writeObject(set);
		objectOutputHistory.close();
	}
	public static HashSet<String> getSetFromHistory() throws IOException
	{
		FileInputStream fileInputHistory=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\TaskList\\history.txt");
		ObjectInputStream objectOutputHistory=new ObjectInputStream(fileInputHistory);
		HashSet<String> historySet=new HashSet<>();
		try {
			historySet=(HashSet<String>) objectOutputHistory.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objectOutputHistory.close();
		return historySet;
	}
}
