package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        //set App Connect
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 25");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        System.out.println("Appium Start");

        delay(4);

        //menu tambah
        MobileElement btnMenuAdd = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnMenuAdd.click();

        delay(2);

//        MobileElement pilihkategory = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
//        pilihkategory.click();
//        MobileElement pilihSatu = (MobileElement) driver.findElementByName("Pulsa");
//        pilihSatu.click();

        //masukan jumlah pengeluaran
        MobileElement jumlah = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlah.click();
        jumlah.sendKeys("50000");

        delay(2);

        //masukan keterangan
        MobileElement note = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        note.click();
        note.sendKeys("bakso kuah dua bungkus");
        delay(2);
        MobileElement back = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout");
        back.click();

        //simpan catatan
        delay(2);
        MobileElement simpan = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout");
        simpan.click();
        System.out.println("berhasil tambah pengeluaran");

        delay(2);

        //scraping
        MobileElement result = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[4]");
        String hasil = result.getText();
        System.out.println("pengeluaran: "+hasil);
        delay(2);

        if(hasil.equals("50.000")){
            System.out.println("validasi pengeluaran berhasil");
        } else {
            System.out.println("validasi invalid");
        }
        delay(2);

        //menu tambah
        btnMenuAdd.click();
        delay(2);

        //masuk ke income
        MobileElement income = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        income.click();
        delay(2);

        //masukan jumlah income
        MobileElement jumlahincome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahincome.click();
        jumlahincome.sendKeys("10000000");
        delay(2);

        //masukan keterangan
        MobileElement noteincome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        noteincome.click();
        noteincome.sendKeys("gaji bulananku");
        delay(2);

        //simpan catatan income
        MobileElement backtwo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout");
        backtwo.click();
        delay(2);
        MobileElement saveincome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        saveincome.click();
        System.out.println("berhasil tambah pemasukan");
        delay(2);

        //scraping income
        System.out.println(hasil);
        System.out.println("pemasukan: "+hasil);
        delay(2);

        if(hasil.equals("10.000.000")){
            System.out.println("validasi pemasukan berhasil");
        } else {
            System.out.println("validasi invalid");
        }

        delay(8);
    }


    public static void delay(long detik) {
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}