package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        //1-Test packegenin altına bir class oluşturalım:
        //2-https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download ");

        //3- code.txt dosyasını indirelim
        WebElement uploadLinki=driver.findElement(By.xpath("//a[text()='upload.txt']"));
        uploadLinki.click();
        Thread.sleep(5000);
        //4-dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosya downloods'a indirilecektir,bize downloads'un dosya yolu lazım

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\upload.txt";

        String arananDosyaYolu=farkliKisim+ortakKisim;

        //geriye o dosya yolundaki dosyanın var olduğunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));


    }

}
