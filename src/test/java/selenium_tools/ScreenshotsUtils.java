package selenium_tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotsUtils {


    public void takeScreenShot() throws Exception {

        String step = AlmacenSteps.getLastStep();
//		String stepValidation = AlmacenSteps.getLastStepValidation();
        String className = ABaseTestCase.getTestClassName().replace(".", "\\");
        String testName = ABaseTestCase.getTestCaseName();

        String file = className + File.separator + testName + File.separator + getFecha() + File.separator + step + "__" + getHora() + ".jpg";
        createDir(file);

        File scrFile = ((TakesScreenshot) ABaseTestCase.getWebDriver()).getScreenshotAs(OutputType.FILE);
        String imageFileDir = System.getProperty("selenium.screenshot.dir");
        if (imageFileDir == null)
            imageFileDir = System.getProperty("java.io.tmpdir");
        FileUtils.copyFile(scrFile, new File(imageFileDir, file));
    }

    /**
     * Crea un directorio.
     *
     * @throws java.io.FileNotFoundException
     */
    public void createDir(String filename) throws FileNotFoundException {
        File f = new File(filename);
        if (!f.exists())
            if (!f.getParentFile().exists())
                f.getParentFile().mkdir();

        f.mkdir();
    }

    private String getHora() {
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date data = new Date();
        return (dateFormat.format(data));
    }

    private String getFecha() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        return (dateFormat.format(data));
    }

}
