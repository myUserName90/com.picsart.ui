# Picsart UI Automation Framework Sample

This framework is designed to run a sample Selenium test in parallel on three different resolutions: 1024x768, 1440x900, and 1366x768.

## Prerequisites

1. Java Development Kit (JDK) 17.
2. Apache Maven.
3. Google Chrome browser.


## How to run the tests

1. Clone the repository:
   ```sh
   git clone https://github.com/myUserName90/com.picsart.ui.git

2. Install all dependencies:
  
``mvn clean install``

3. Run the test with in parallel on three different resolutions: 1024x768, 1440x900, and 1366x768 (default resolution 1920x1080).

```mvn clean test```