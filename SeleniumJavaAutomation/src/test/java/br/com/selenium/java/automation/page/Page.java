package br.com.selenium.java.automation.page;

import org.openqa.selenium.support.PageFactory;
import br.com.selenium.java.automation.driver.factory.DriverClass;

public class Page extends DriverClass {

	@SuppressWarnings("unchecked")
	private static <T> T getPage(Class<?> clazz) {
		T page = null;
		try {
			page = (T) clazz.newInstance();
		} catch (InstantiationException instantiationException) {
			instantiationException.printStackTrace();
		} catch (IllegalAccessException illegalAccessException) {
			illegalAccessException.printStackTrace();
		}
		PageFactory.initElements(getDriver(), page);
		return page;
	}

	public static PageObject PageObject() {
		return getPage(PageObject.class);
	}

	public static CartPO CartPage() {
		return getPage(CartPO.class);
	}
}