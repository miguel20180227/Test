package exm.Test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Data.AdminProperties;
import Framework.Cls_Cross_Browsing;
import Framework.Cls_Encontrar_Elemento;

public class Test_Belatrix {

	Cls_Cross_Browsing Obj_Cross_Browsing ;
	Cls_Encontrar_Elemento Obj_Encontrar_Elemento;
	Cls_Encontrar_Elemento ATH;
	public static String Str_Error;	
	Actions actions;
	WebDriver Obj_Driver;
	String str_Results = "";
	double dbl_Price_1;
	double dbl_Price_2;
	double dbl_Price_3;
	double dbl_Price_4;
	double dbl_Price_5;

	//Variables
	String str_Field_Research = ".//*[@id='gh-ac']";
	String str_Btn_Research = ".//*[@id='gh-btn']";
	String str_Chk_Brand = "//div[@id='LeftNavContainer']/div[@class='asp asp-left-nav']/div[2]//div[@class='brnd']/div[8]//input[@role='presentation']";
	String str_Chk_Size = ".//*[@id='e1-29']";
	String str_Field_Results = ".//*[@id='cbelm']/div[3]/h1/span[1]";
	String str_DD_Order = ".//*[@id='DashSortByContainer']/ul[1]/li/div/a";
	String str_DD_Order_Ascendant = ".//*[@id='SortMenu']/li[3]/a";
	String str_Shoes_1 = "//ul[@id='GalleryViewInner']/li[2]/div//div[@class='bid']/span[1]";
	String str_Shoes_2 = "//ul[@id='GalleryViewInner']/li[3]/div//span[@class='amt']/span";
	String str_Shoes_3 = "//ul[@id='GalleryViewInner']/li[4]/div//span[@class='amt']/span";
	String str_Shoes_4 = "//ul[@id='GalleryViewInner']/li[5]/div//span[@class='amt']/span";
	String str_Shoes_5 = "//ul[@id='GalleryViewInner']/li[6]/div//span[@class='amt']/span";


	public void cargarDriver(){
		Obj_Cross_Browsing = new Cls_Cross_Browsing();
		Obj_Cross_Browsing.Eleccion_Browser(AdminProperties.BROWSER,AdminProperties.LOG_OPTION);
		Obj_Driver = Obj_Cross_Browsing.get_Obj_Driver();
	}

	public void ingresarAplicacion(){
		try{
			Obj_Cross_Browsing.Abrir_Website(Obj_Driver, "https://www.ebay.com/");			
			actions = new Actions(Obj_Cross_Browsing.get_Obj_Driver());
			actions.className = this.getClass().getSimpleName();
		}catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00007): Error inicializando el navegador , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

//	@Test
	public void Busqueda(String str_Busqueda){
		try{
			actions.esperarSegundos(3);
			actions.TypeByXpath(str_Field_Research, str_Busqueda);
			actions.clickByXpath(str_Btn_Research);
			actions.clickByXpath(str_Chk_Brand);
			actions.clickByXpath(str_Chk_Size);	
			str_Results = actions.GetTextByXpath(Obj_Driver, str_Field_Results);	
			System.out.println("This is the result of shoes: " + str_Results);
			actions.clickByXpath(str_DD_Order);
			actions.clickByXpath(str_DD_Order_Ascendant);

			String str_Price_1 = actions.GetTextByXpath(Obj_Driver, str_Shoes_1);
			str_Price_1 = str_Price_1.replace("COP $", "");
			str_Price_1 = str_Price_1.replace(" ", "");
			if (str_Price_1.equals("")) str_Price_1 = "0";
			System.out.println("The price 1 is: "+ str_Price_1);
			String str_Price_2 = actions.GetTextByXpath(Obj_Driver, str_Shoes_2);
			str_Price_2 = str_Price_2.replace("COP $", "");
			str_Price_2 = str_Price_2.replace(" ", "");
			if (str_Price_2.equals("")) str_Price_2 = "0";
			System.out.println("The price 2 is: "+ str_Price_2);
			String str_Price_3 = actions.GetTextByXpath(Obj_Driver, str_Shoes_3);
			str_Price_3 = str_Price_3.replace("COP $", "");
			str_Price_3 = str_Price_3.replace(" ", "");
			if (str_Price_3.equals("")) str_Price_3 = "0";
			System.out.println("The price 3 is: "+ str_Price_3);
			String str_Price_4 = actions.GetTextByXpath(Obj_Driver, str_Shoes_4);
			str_Price_4 = str_Price_4.replace("COP $", "");
			str_Price_4 = str_Price_4.replace(" ", "");
			if (str_Price_4.equals("")) str_Price_4 = "0";
			System.out.println("The price 4 is: "+ str_Price_4);
			String str_Price_5 = actions.GetTextByXpath(Obj_Driver, str_Shoes_5);
			str_Price_5 = str_Price_5.replace("COP $", "");
			str_Price_5 = str_Price_5.replace(" ", "");
			if (str_Price_5.equals("")) str_Price_5 = "0";
			System.out.println("The price 5 is: "+ str_Price_5);

			dbl_Price_1 = Double.parseDouble(str_Price_1);
			dbl_Price_2 = Double.parseDouble(str_Price_2);
			dbl_Price_3 = Double.parseDouble(str_Price_3);
			dbl_Price_4 = Double.parseDouble(str_Price_4);
			dbl_Price_5 = Double.parseDouble(str_Price_5);

			assert(dbl_Price_1 < dbl_Price_2):"Price 1: " + dbl_Price_1 + "is greater than Price 2: " + dbl_Price_2;
			assert(dbl_Price_2 < dbl_Price_3):"Price 1: " + dbl_Price_1 + "is greater than Price 2: " + dbl_Price_2;;
			assert(dbl_Price_3 < dbl_Price_4):"Price 1: " + dbl_Price_1 + "is greater than Price 2: " + dbl_Price_2;
			assert(dbl_Price_4 < dbl_Price_5):"Price 1: " + dbl_Price_1 + "is greater than Price 2: " + dbl_Price_2;

			actions.TypeKeysByXpath(Obj_Driver, str_Btn_Research, Keys.PAGE_DOWN);
			actions.TakeScreenshot(Obj_Driver);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00008): Error en Busqueda , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	public void Cerrar_Pagina (){
		try{
			Obj_Driver.quit();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (000013): Error en cerrar pagina de bancos , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	public void salir() throws InterruptedException{
		Thread.sleep(30000);
		Obj_Driver.quit();
	}
}
