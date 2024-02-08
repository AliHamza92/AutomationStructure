# Automation Framework Structure

In this README file, you'll find the structure for automating tasks in Java using the Selenium API with Maven and the TestNG framework.

**Structure Overview:**

Base Class, Properties Class, and Main Test Class:

The framework consists of three main components: Base Class, Properties Class, and Main Test Class.

**Base Class Features:**

The Base Class contains conditions for different browsers using if-else statements.

Users can select the desired browser in the Properties Class.

If the user specifies 'chrome' browser, the script dynamically loads the Chrome browser before the test execution.

**Properties Class:**

Users can configure test execution parameters, including browser selection, in the Properties Class.

**Main Test Class Features:**

Utilizes an external Excel file to read and input data into website form fields, adhering to the structure of the website's form data.

The script reads locators from a separate properties file, enabling testers to maintain and update locators externally.
**Advantages:**


Ease of Maintenance: Separating locators into an external file simplifies maintenance. Testers can easily update locators if the website structure changes.

Flexibility: Users can choose browsers dynamically, enhancing the flexibility of the automation framework.

This structured approach enhances maintainability and flexibility, empowering testers to efficiently conduct automated testing with ease.
