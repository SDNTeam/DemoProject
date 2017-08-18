import java.io.File;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = System.getProperty("user.dir") + "/src/main/resources/config.xml";
		
		File f = new File(fileName);
		
		System.out.println(f.getName());
		
		
	}

}
