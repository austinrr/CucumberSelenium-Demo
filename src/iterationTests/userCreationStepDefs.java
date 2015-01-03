package iterationTests;

import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

import pageObjects.HomePage;
import pageObjects.NewUserPage;
import pageObjects.UserListPage;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import testFramework.SeleniumBase;

public class userCreationStepDefs {
	
	private SeleniumBase script;
	private HomePage homePage;
	private NewUserPage newUserPage;
	private UserListPage userListPage;
	
	List<Map<String, String>> users;

	public void init() throws Exception {
	   script = new SeleniumBase();
	   script.setUp();
	   homePage = new HomePage();
	   newUserPage = new NewUserPage();
	   userListPage = new UserListPage();
	}

	@Before
	public void startUp() throws Exception {
		init();
//		home.goToHomePage();
		script.goToHomePage();
	}
	
	@Given("^I am on the NewUser page$")
	public void i_am_on_the_NewUser_page() throws Throwable {
		homePage.clickNewUserLink();
		System.out.println("Made it to New User page.");
	}

	@When("^I submit a new user:$")
	public void i_submit_a_new_user(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		 users = arg1.asMaps(String.class, String.class);
		
		for (Map<String, String> map : users) {
			String username = map.get("name");
			String email = map.get("email");
			newUserPage.enterUserName(username);
			newUserPage.enterEmailField(email);
		}
		
		newUserPage.pressSelectButton();
	}

	@Then("^I am directed to the User list page$")
	public void i_am_directed_to_the_User_list_page() throws Throwable {
		boolean correctPage = userListPage.verifyCorrectUrl();
//		System.out.println("Redirected to the User List page: " +correctPage);
	}

	@Then("^The user appears in the list$")
	public void the_user_appears_in_the_list() throws Throwable {
		List<Map<String, String>> pageData = userListPage.getUserTable();
		int matchesNeeded = users.size();
		int matchesFound = 0;
		
		for (Map<String, String> map1 : users) {
			for (Map<String, String> map2 : pageData) {
				System.out.println("Comparing "+ map1.values() + " to " + map2.values());
				if (map1.values().containsAll(map2.values())) matchesFound ++;
			}
		}
		assertTrue("Matches needed should be equal to matches found.", matchesNeeded < matchesFound);
	}
	
	@After
	public void shutDown() {
		script.tearDown();
	}

}
