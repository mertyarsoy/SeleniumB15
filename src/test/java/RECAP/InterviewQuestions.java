package RECAP;

public class InterviewQuestions {
    /*
    1-What are the advantages and disadvantages of Selenium?

    ADVANTAGES:
    *Free Source Tool
    *It supports multiple languages and browsers
    *It has big community

    DISADVANTAGES:
    *You can't automate Captcha,pictures,mobile applications etc...
    *There is no direct call or support (customer service) for Selenium
    *It only automates Web Applications (BROWSERS)
    *It doesn't have any system to generate report,so we use external resources(TestNG,Cucumber etc...)

    2-What type of testing can you automate with Selenium?
    *Regression Testing
    *Smoke Testing
    *Functional (Positive/Negative) Testing

    3-What are the test types you do not automate with Selenium?
    *Performance Testing(Jmeter --> It is not really hard to learn)
    *Manual Testing(captcha,pictures)
    *Non-Functional Testing(stress testing,loading testing,performance...)
    *Adhoc Testing(randomly testing)

    4-What is Locator in Selenium? What types of Locators do you use in your FrameWork?
     -->Locators is a way to find the element/s from DOM(Development Tool/Page)
     The locators that I am using in my FrameWork are:
     a)ID = finds the element by ID attribute
     b)Name = finds the element by Name attribute
     c)className = finds the element by className attribute
     d)LinkText = finds the element by LinkText tagName
     e)PartialLinkText = finds the element by PartialLinkText tagName
     f)CSS = finds the element by CSS attribute (id = "#" && class = ".")
     g)Xpath = finds element by xpath which this locator is the most reliable one compared with the others

     5-How do you handle Dynamic Elements in UI Automation?(CVS Health)
      -->In my project,I have faced many dynamic elements during UI Automation:
         To handle this issue I did:
         *I used parent-child relationship for the elements
         *I used different ways to locate the elements(like following-siblings,preceding siblings,contains etc..)
         *I found the element with different attribute which is not dynamic

     6-What are the difference between driver.get(); and driver.navigate();?
      Navigate()--> It does not wait webElements to be loaded from page.(It waits for only specific elements that you are looking from page)
      -->It has methods(to,refresh,back,forward)

      Get()--> It waits all the webElements to be loaded from page
     --> It does not have any methods

     7-What are the difference between driver.close(); and driver.quit();?
      Driver.close()--> It specifically closes the window that the driver is pointing
      -->It closes only one tab
      Driver.quit()--> It closes all the tabs that are open during the automation

     8-What is Xpath?Can you tell me about the types of Xpath?Which one do you use the most?
     8.1-What is the difference between Absolute and Relative Xpath?
      -->XPATH:It is one of the most reliable locator that I use in Selenium to find the element
        ->There are two types of Xpath:
         a)Absolute Xpath:
          *It goes from all the way top(html) to child
          *It starts with single "/"

         b)Relative Xpath:
          *It goes directly to the child or parent-child (Example = //div[@id='parent']//a[contains(text(),'child')]
          *It starts with double slash "//"

         I use definitely "Relative Xpath" the most since it is more functional and effective to locate the elements.

     9-How do you handle drop-downs?
      In my project,I was handling the drop-downs with different ways:
      a)I would definitely check the tag of the WebElement(location)
       *If the location has "Select" tagName then -->I use Select class (Example = Select select = new Select(WebElement);
       *If the location does not have "Select" tagName then -->I can use:
          ->Actions class methods like click or WebElement/s method click and choose option
          ->I would use sendKeys() to choose the option

     10-Can you tell me what do you know about Select class and it's methods ?
      Select class is a class to handle drop-downs:
       -->It is really useful for my project, and WebElement must have Select tagName
        -Select select = new Select(location);
         select.selectByVisibleText("textValue");
         select.selectByValue("value");
         select.selectByIndex("indexNumber");
         select.getFirstSelectedOption(); --> It will give you default option selected
         select.getOptions(); --> It will give you all options(List<String>)

     11-What kind of Exceptions have you faced so far in your Automation Framework?(At least 5)
      ->NoSuchElementException
      ->StaleElementReferenceException
      ->ElementInterceptedException
      ->ElementIsNotIntractableException
      ->NoSuchWindowsException
      ->NoSuchFrameException
      ->TestNGException
      ->UnHandledException
      ->TimeOutException
      ->InvalidSelectorException

     12-How do you handle StaleElementReferenceException?
      In my project, this exception is one of the hardest ones that was giving me headache
        This exception happens when:
         *The DOM is not updated fast
         *The DOM's element values is changed
         *The page is refreshed
       -->Wait times might solve the issue
        **I would use Thread.sleep() or Explicitly Wait with the condition
       ***I would re-assign and re-initialize the WebElement
         *I would refresh the page

     13-How do you handle pop-ups?Can you tell me methods that you handle JS Alert?

     There are different types of pop-ups that I've faced during automation?
      1-Operation System(OS):We cannot handle it directly with Selenium
      2-HTML alert/pop-up:I just need to find the element and click on it(like OK or Cancel Button)
      3-JavaScript alert/pop-up:I handle it with Alert interface
        SYNTAX = Alert alert = driver.switchTo().alert();
        alert.accept(); --> It clicks "OK" button from alert pop-up
        alert.dismiss(); --> It clicks "Cancel" button from alert pop-up
        alert.getText(); --> It gets the text from alert pop-up
        alert.sendKeys(); --> It sends the key to the alert pop-up

     14-What do you know about iFrame?How do you handle it in your Automation?
     -->iFrame is HTML inside of HTML
        It is used for protection purposes
        It is widely used for Ads,Docs or Videos

     -->First, switch your frame based on the value of WebElement:
        driver.switchTo().frame(id or name)
        driver.switchTo().frame(WebElement)
        driver.switchTo().frame(index)
        driver.switchTo().ParentFrame()--> It will go to the parent frame
        driver.switchTo().defaultContent()--> It will directly go to the main/default HTML
                                              No matter what how many times you switch your frame from parent to child
                                              with this method, it will directly skip all  the parents and go to the main HTML

     NOTE:If you do not handle this iFrame, you will get NoSuchElementException
     NOTE2:If the value of switchFrame is wrong,you will get NoSuchFrameException

     15-What do you know about Actions class?Can you tell me the methods you are using the most during your automation?
      Actions class basically does mouse functionalities
      I can say it is really useful in some cases during my Automation to handle some elements
      Some important methods are:

      ***** --> ContextClick --> It right-clicks on the WebElement = INTERVIEW QUESTION
      ***** --> DoubleClick --> It double-clicks on the WebElement
      ***** --> DragAndDrop --> It drags and drops the WebElement from one spot to another
         ** --> ClickAndHold --> It clicks and holds the WebElement
      ***** --> MoveToElement --> It hovers over the WebElement
         ** --> release --> It releases the WebElement that you are holding(It mostly comes after ClickAndHold)
            -->sendKeys(); --> It sends the key
      ***** --> perform(); --> It performs the actions method(WITHOUT THIS METHOD NONE OF THE OTHER METHODS WILL WORK)

     16-What is the difference between driver.findElement and driver.findElements?

     1-FindElement
     a)Syntax is different (driver.findElement(By.locator(""));
     b)returns WebElement
     c)Once it fails,it throws "NoSuchElementException"

     2-FindElements
     a)Syntax is different (driver.findElements(By.locator(""));
     b)returns List<WebElement>
     c)Once it fails,it throws nothing(empty list)

     17-Can you tell me driver and WebElement methods you are using during automation mostly?
      1-Driver methods:
      a)get();
      b)navigate();
      c)getTitle();
      d)getCurrentUrl();
      e)switchTo();
      f)quit();
      g)close();
      h)GetWindowHandle/s();
      i)manage();

      2-WebElement methods:
      a)click();
      b)sendKeys();
      c)getText();
      d)isDisplayed();
      e)isSelected();
      f)getAttribute();
      g)getCSSValue();
      h)clear();
      i)submit();

     18-What is the difference between check-box and radio-button?
      a)CheckBox --> You can click multiple boxes
      b)RadioButton --> You can only choose one at a time

     19-How do you handle multiple windows in Automation?What is the difference between getWindowHandle(); and getWindowHandles();?
      To be able to handle the window/s?
       -->I need to switch my driver into the specific window with my logic
         Set<String> allWindows = driver.getWindowHandle();

         for(String pageID:allWindows){
         driver.switchTo.window(pageID);
         if(driver.getTitle.contains(expectedTitle){
         break;
         }}

      1-Use getWindowHandles to store all pages ID as a Set
      2-Loop through all pages and switch
      3-Break the loop when title is what I am looking for
      NOTE: getWindowHandle(); --> returns String with single page id
            getWindowHandles(); --> returns Set<String> with all unique page ids

     20-How do you scroll down-up in WebBrowsers during your automation?
  *****--> I mostly use JS scrollIntoView script(I store it in my BrowserUtils class for any-time usage)
       -->actions.scrollByAmount(x,y)
       -->Keys.PageUp or Down
       -->Keys.ARROW_DOWN or UP

     21-How do you upload a file in Selenium?
       -->First of all, you need to find the location of "Choose" button
       -->Find the path of the file that you are going to attach(//C://Users//src//test//usaflag.png)
       -->Then send the keys of location to the "Choose" button

     22-What is the difference between Assert and Soft.Assert?
     Assert: is a class that has some methods to validate actual and expected data's
      SYNTAX = Assert.assertEquals(); or Assert.assertTrue();
      When it fails, it throws exception right away and do not execute the next line of codes

     Soft.Assert: is a class that has some methods to validate actual and expected data's
      We need to create an object
      SYNTAX = SoftAssert.softAssert = new SoftAssert();
      When it fails, it does not throw any exception then it keeps executing the next line of codes
      You must use Assert.all() to make it work properly otherwise it will pass all the time

     23-Can you tell me a little about your Singleton Pattern Design?Can you make the constructor private,static or final?
      First of all, I appreciate for this question since I like Singleton logic because in the past I was working on
      my driver and getting lots of NullPointerException.With the help of Singleton, I centralize my driver which reduces
      the amount of exception I got which means it is more reliable and safe to use

        -->I basically Encapsulate my Singleton:
           a)I need to have Private WebDriver
           b)I need to have Private Constructor
           c)Put if condition to check my driver is null or not
           d)Create a public method to call it from other classes

     24-What kind of TestNG annotation do you use in your project?Can you tell me what is the purpose of @Parameter usage?

                      PLEASE CHECK THE SUBLIME TEXT --> IT IS ALL EXPLAINED IN DETAILS ON SUBLIME TEXT

     25-What do you know about @DataProvider?Why do you use it in your Framework?

                      PLEASE CHECK THE SUBLIME TEXT --> IT IS ALL EXPLAINED IN DETAILS ON SUBLIME TEXT

     26-What do you know about WaitTimes?Can you tell me the difference between Thread.sleep();, ImplicitlyWait();,ExplicitlyWait(); and FluentWait();

                      PLEASE CHECK THE SUBLIME TEXT --> IT IS ALL EXPLAINED IN DETAILS ON SUBLIME TEXT










     */
}
