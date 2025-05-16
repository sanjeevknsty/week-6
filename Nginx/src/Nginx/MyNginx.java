package Nginx;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class MyNginx {
	
	public static int DEFAULT_PORT = 9000;
	public static int port;
//	private HttpServer httpServer;
	
	public static void main(String[] args) {
		try {
			
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(DEFAULT_PORT), 0); 
        httpServer.createContext("/", new Handlers.RootHandler());
        
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
