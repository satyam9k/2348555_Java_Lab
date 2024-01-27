# Linear Regression Analysis GUI

## Objective of the Project

The Linear Regression Analysis GUI is a Java-based desktop application designed for simple linear regression analysis. The primary objective is to provide users with an intuitive tool for inputting X and Y variables, conducting regression calculations, visualizing results, and optionally saving analyses to a database.

## Features

### 1. Variable Input
Users can input X and Y variables through a graphical user interface, supporting up to 100 variable pairs.

### 2. Regression Analysis
The application calculates key metrics of simple linear regression, including slope, intercept, R^2, mean squared error (MSE), coefficient, and more.

### 3. Prediction
Users can predict the Y value for a given X value based on the calculated regression model.

### 4. Save to Database
Results of the regression analysis can be saved to a MySQL database for future reference.

### 5. Know More
The "Know more about regression" button uses a servlet to redirect users to a web page explaining the concept of regression.

### 6. Graph (Future Work)
A placeholder button "Show Graph" suggests a feature for displaying a scatter plot with a best-fit line, though this functionality is not yet implemented.

## How to Use Each Functionality

### 1. Add Variable
- Click on "Add Variable" to input X and Y variable pairs into the table.
- Users can input up to 100 variable pairs.

### 2. Calculate
- Click on "Calculate" to perform the regression analysis.
- View results, including slope, intercept, R^2, MSE, coefficient, and intercept, in the "Regression Result" section.

### 3. Predict
- Enter an X value in the "Predict" section.
- Click "Predict Y" to calculate and display the predicted Y value.

### 4. Save to Database
- Click "Save to Database" to store regression analysis results in a MySQL database.
- Users must provide the database connection details (URL, user, password) in the code.

### 5. Know More
- Click "Know more about regression" to be redirected to a web page that explains the regression concept.

### 6. Show Graph (Future Work)
- The "Show Graph" button is a placeholder for a future feature that will display a scatter plot with a best-fit line.

## Use of Database GUI and Servlet

### Database GUI
- The application uses a MySQL database to store regression analysis results.
- Users can save results to the database using the "Save to Database" functionality.
- Database connection details (URL, user, password) need to be provided in the code.

### Servlet
- The "Know more about regression" button uses a servlet to redirect users to a web page that explains the regression concept.

## Future Work

- Implement the "Show Graph" functionality to display a scatter plot with a best-fit line.
- Enhance the servlet functionality for displaying regression results on a web page.

---
Satyam Kumar
https://www.linkedin.com/in/satyamkumar09/
