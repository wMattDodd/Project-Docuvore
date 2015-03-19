package com.github.docuvore.prototype.server;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    String home() {
    	String result = null;
    	
    	try {
    		byte[] rawData = FileSystemUtils.readFile("src/main/resources/com/github/docuvore/prototype/examples/example.html");
    		String textData = new String(rawData);
    		result = textData;
		} catch (IOException e) {
			if(!(e instanceof FileNotFoundException))
			{
				e.printStackTrace();
			}
			//result = Paths.get(".").toAbsolutePath().toString();
			result = e.getMessage();
		}
    	
        return result;
    }
}