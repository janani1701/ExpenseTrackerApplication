# ExpenseTrackerApplication


The **Expense Tracker App** is a Java application that allows users to track and manage their expenses. It provides the functionality to add new expenses, view total expenses for the current month and year, view expenses for a custom month, and view expenses for custom categories within the current month, current year, or a custom month.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)


## Overview

The Expense Tracker App is designed to help users keep track of their expenses by providing a user-friendly interface to manage and view expenses. The application is organized into several classes, each responsible for specific tasks:

- `Expense`: Represents an individual expense with attributes such as category, amount, and date.
- `User`: Stores user details like username and email.
- `ExpenseDatabase`: Manages a list of expenses and allows for adding and retrieving expenses.
- `ExpenseManager`: Manages the core functionality of adding expenses and calculating the total expenses for different time periods.
- `CustomExpenseViewer`: Provides custom views for expenses, including totals for a specific category in a custom month.

## Features

1. **User Registration:** Users can provide their username and email when starting the application.

2. **Add New Expense:** Users can add a new expense by specifying the category, amount, and date of the expense. The application validates the date format to ensure accuracy.

3. **View Expenses for This Month:** Users can view the total expenses for the current month.

4. **View Expenses for This Year:** Users can view the total expenses for the current year.

5. **View Expenses for Custom Month:** Users can enter a custom month (1-12) to view the total expenses for that specific month.

6. **View Expenses for Custom Category This Month:** Users can select a category (Food, Travel, Rent, Utilities, or Entertainment) to view the total expenses for that category in the current month.

7. **View Expenses for Custom Category This Year:** Similar to the previous option, but for the current year.

8. **View Expenses for Custom Category Custom Month:** Users can select a category and a custom month to view the total expenses for that category in the specified month.

## Getting Started

To get started with the Expense Tracker App, follow these steps:


1. Open the project in your favorite Java development environment.

2. Run the ExpenseApp class to start the application.

3. Follow the on-screen instructions to register your user details and use the application.

## Usage

When you run the ExpenseApp, you will be presented with a menu to interact with the application. You can choose options by entering the corresponding number:

1. **Add new expense:** You can add a new expense by providing the category, amount, and date.

2. **View expenses for this month:** View the total expenses for the current month.

3. **View expenses for this year:** View the total expenses for the current year.

4. **View expenses for custom month:** Enter a custom month (1-12) to view expenses for that month.

5. **View expenses for custom category this month:** Choose a category (1-Food, 2-Travel, 3-Rent, 4-Utilities, 5-Entertainment) to view expenses for that category in the current month.

6. **View expenses for custom category this year:** Similar to the previous option, but for the current year.

7. **View expenses for custom category custom month:** Select a category and a custom month to view expenses for that category in the specified month.

8. **Exit:** Quit the Expense Tracker App.

## Contributing

If you would like to contribute to the development of the Expense Tracker App, please follow these guidelines:

1. Fork the repository to your own GitHub account.

2. Create a new branch with a descriptive name for your feature or fix.

3. Make your changes and ensure they are well-documented and tested.

4. Submit a pull request to the original repository.


   
