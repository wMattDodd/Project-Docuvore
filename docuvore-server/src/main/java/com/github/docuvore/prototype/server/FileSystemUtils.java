package com.github.docuvore.prototype.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@UtilityClass
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class FileSystemUtils {
	
	static int END_OF_FILE_CODE = -1;
	
	public static byte[] readFile(@NonNull String path) throws IOException
	{
		byte[] result = null;
		List<Byte> array = new ArrayList<Byte>();
		InputStream input = null;
		
		try {
			input = new FileInputStream(path);
			int data = input.read();
			while(data != -1) {
			  addByteToArray(array, (byte) data);

			  data = input.read();
			}
		}
		finally
		{
			if(input != null)
			{
				input.close();
			}
		}
		
		Object[] intermediate = array.toArray();
		int arraySize = intermediate.length;
		result = new byte[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			result[i] = ((Byte) intermediate[i]).byteValue();
		}
		
		return result;
	}
	
	private static List<Byte> addByteToArray(@NonNull List<Byte> array, Byte data) {
		if(data != null)
		{
			array.add(data);
		}
		return array;
	}
}
