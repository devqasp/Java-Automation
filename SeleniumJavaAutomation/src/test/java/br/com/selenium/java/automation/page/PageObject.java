package br.com.selenium.java.automation.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class PageObject {

	@FindBys({ @FindBy(xpath = ".//input") })
	@CacheLookup
	private List<WebElement> txtHomePage;

	@FindBy(how = How.XPATH, using = ".//input[@id='search_query_top']")
	@CacheLookup
	private WebElement txtSearchHomePage;

	@FindBy(how = How.XPATH, using = "//*[@id='searchbox']/button")
	@CacheLookup
	private WebElement btnSearchHomePage;

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/div[1]/div[2]/div[2]")
	@CacheLookup
	private WebElement divSearchResult;

	public List<WebElement> getTxtHomePage() {
		return txtHomePage;
	}

	public WebElement getTxtSearchHomePage() {
		return txtSearchHomePage;
	}

	public WebElement getBtnSearchHomePage() {
		return btnSearchHomePage;
	}

	public WebElement getDivSearchResult() {
		return divSearchResult;
	}
}