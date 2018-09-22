package com.portal.test.portal;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesBase;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;

public class MyTest
{
	public static void main(String args[]) throws MalformedURLException, IOException
	{
		//Set only once per Jenkins job
		BatchInfo mybatch = new BatchInfo(System.getenv("APPLITOOLS_BATCH_NAME")); 
		mybatch.setId(System.getenv("APPLITOOLS_BATCH_ID"));
		//EyesBase eyes;
		//End of - Set only once per Jenkins job
		
		Eyes eyes = new Eyes();

        // Initialize the eyes SDK and set your private API key.
        eyes.setApiKey("kpNPv4d85D7tePADMLAY5Qw3nJFafGzeNDduPd4AgTo110");

        // Define the OS and hosting application to identify the baseline.
        eyes.setHostOS("Windows 10");
        eyes.setHostApp("My Test in Chrome");
        eyes.setBatch(mybatch);
        BufferedImage img;

        try {

            // Start the test with a viewport size of 800x600.
            eyes.open("Applitools site", "My first Screenshot!", new RectangleSize(800, 600));

            // Load page image and validate.
            img = ImageIO.read(new URL("https://applitools.com/images/tutorials/applitools_hero.png"));

            // Visual validation.
            eyes.checkImage(img, "Contact-us page");

            // End visual UI testing.
            eyes.close();

        } finally {

            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();

        }
	//System.out.println("My name is Binay");	
		
	}

}
