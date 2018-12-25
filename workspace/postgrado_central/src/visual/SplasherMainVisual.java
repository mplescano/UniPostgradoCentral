package visual;

import java.io.IOException;
import java.io.InputStream;

import util.ResolvedProperties;
import util.Utilities;
import visual.util.splash.SplashWindow;

public class SplasherMainVisual {
	public static void main(String[] args) {
		ResolvedProperties _properties = new ResolvedProperties();
		InputStream isConfig = null;
		
		isConfig = Thread.currentThread().getContextClassLoader().getResourceAsStream("propiedades/config.properties");
		try {
			_properties.load(isConfig);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathImages = _properties.getProperty("pathImages");
		
		String prefixImages = pathImages + "/images/hdr-";
	    String filenameImage = Utilities.getRandomSecuencial(prefixImages, ".jpg", 3, '0', 22);
//	    System.out.println(filenameImage);
//	    File file = new File(filenameImage);
//	    System.out.println("existes:" + file.exists());
//	    File file2 = new File(".");
//	    System.out.println("existes:" + file2.exists());
//	    System.out.println("path .:" + file2.getAbsolutePath());
        SplashWindow.splash(filenameImage);
        SplashWindow.invokeMain(MainVisual.class.getName(), null);
        SplashWindow.disposeSplash();
	}
}