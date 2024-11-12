# LogicExpression Toolkit

A Java-based framework for constructing and evaluating complex logical expressions.

## Description

The LogicExpression Toolkit is a comprehensive Java framework designed to build, evaluate, and manipulate complex logical expressions. This application facilitates handling logical operations such as OR, XOR, NAND, NOT, and others. It allows for the transformation of any logical expression into forms that exclusively use NAND or NOR operations and simplifies expressions to their minimal forms.

## Key Features

- **Expression Evaluation**: Dynamically evaluate expressions based on user-defined variable assignments.
- **Expression Transformation**: Convert any expression into equivalent forms using solely NAND or NOR operations.
- **Expression Simplification**: Reduce expressions to their simplest form, facilitating easier understanding and further manipulation. 
- **Robust Error Handling**: Efficiently handle cases where variables are unassigned or expressions are malformed.

## Object-Oriented Design

The project leverages object-oriented programming principles to provide a modular, extensible, and maintainable codebase:

- **Inheritance**: Classes like `BinaryExpression` and `UnaryExpression` serve as base classes for specific logical operations, promoting code reuse and logical grouping.
- **Polymorphism**: Through interfaces and abstract classes, the toolkit handles various expression types dynamically, allowing for flexible expression manipulation and evaluation strategies.
- **Encapsulation**: Data and methods are encapsulated within classes, ensuring controlled access and modification of the core expression data structures.
- **Composition**: Complex expressions are built using simpler expression components, demonstrating the composition capabilities of OOP.

## Example
![image](https://github.com/tomerp1812/LogicExpresion/assets/110912180/53384e7e-5379-41cf-849a-c32fe3b951d8)

## Installation

Open command line & clone the repository to your local machine:

```bash
git clone https://github.com/tomerp1812/LogicExpresion.git
cd LogicExpresion
```
To run the project:
```bash
cd src
javac ExpressionsTest.java
java ExpressionsTest 
```
