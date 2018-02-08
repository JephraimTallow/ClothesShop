# ClothesShop
Webdriver example running against a mock shopping site

# Setup
The project is built using Maven and run simply by 'mvn test' from the project directory. This will run the CRUDTest unit tests along with the ClothesStore WebDriver tests.

# Cucumber Style
The WebDriver tests have purposely been written in a very granular Cucumber style with associated .feature file - this allows specific order of events to be easily changed when driving a website. It also provides great visibility of exactly what steps occurred and the out of the box reports generated (/target/bdd/index.html) are very clear.

# Technical Debt
Implicit WebDriver waits did not perform as expected. Therefore Thread.sleep() has been used - not an ideal solution, and one that would be revisited. That said, I have found on previous use of WebDriver waits, that although an item might be present in the DOM, and therefore WebDriver available, this is not the case when trying to perform an action upon it. 

Certain shopping items have been hard coded, where in fact, these would be taken from the page itself. 

TestSteps.java contains all of the steps and as such the class has far too many lines. This would be factored into several smaller Step classes, relating to the relevent pages.

Testing expected data against actual data requires an object to contain this. The Spring framework allows 'beans' to be passed around and shared between classes. Using this framework would allow object (such as a shopping cart) to be created and maintained all the way up to the final checkout, where the object would be available for comparison against.

Logging - must be implemented. Try / catch blocks should certainly be logged or handled appropriately.

Error handling - approach to be determined. Should all errors be caught and logged, should the error be allowed to propagate? A strategy needs to be decided.

CRUDTest - the URLConnection section is identical apart from the URL string. This information should be refactored to allow it to be shared rather than duplicated in each test.

Screenshot location - this is currently set using a linux file style. This should be changed to suit any system type.
