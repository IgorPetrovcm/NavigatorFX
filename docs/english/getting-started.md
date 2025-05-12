# Getting Started

The NavigatorFX library is designed to simplify navigation between Screens(Views) in JavaFX applications. It allows you to easily switch between different scenes and manage the state of the application.

## Installation

[Install](installation.md) NavigationFX.

Add dependencies to your project:
```xml
<dependency>
    <groupId>com.github.igorpetrovcm.navigationfx</groupId>
    <artifactId>fxml</artifactId>
</dependency>
<dependency>
    <groupId>com.github.igorpetrovcm.navigationfx</groupId>
    <artifactId>util</artifactId>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
</dependency>
```

## JavaFX FXML

Create two simple Views in the `.fxml` format along the `main/resources/fxml` path, for example, `view 1.fxml` and `view2.fxml`. Later, you will configure the paths to the "fxml" files yourself.

I also recommend that in the future you create your Views along a path proportional to the path of your View Сontrollers, for example, you have a controller `View1.java` in the directory `main/java/com/example/*`, then the `.fxml` file of your controller will be in the `main/resources/com/example/*` directory, and it should be called `View1.fxml`. This way we will reduce the cost of manually installing the path in the future.

- `view1.fxml`:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>

    <?import java.lang.*?>
    <?import java.util.*?>
    <?import javafx.scene.*?>
    <?import javafx.scene.control.*?>
    <?import javafx.scene.layout.*?>

    <AnchorPane xmlns="http://javafx.com/javafx"
                xmlns:fx="http://javafx.com/fxml"
                fx:controller="com.example.View1Controller"
                prefHeight="400.0" prefWidth="600.0">

        <Label
            text="Hello World!"
            AnchorPane.bottomAnchor="50"
            AnchorPane.leftAnchor="50"
            AnchorPane.rightAnchor="50"
            AnchorPane.topAnchor="50"
            fx:id="lHello">
        </Label>
        <Button
            text="go to View2"
            fx:id="btnGoto">
        </Button>

    </AnchorPane>
    ```
- `view2.fxml`:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>

    <?import java.lang.*?>
    <?import java.util.*?>
    <?import javafx.scene.*?>
    <?import javafx.scene.control.*?>
    <?import javafx.scene.layout.*?>

    <AnchorPane xmlns="http://javafx.com/javafx"
                xmlns:fx="http://javafx.com/fxml"
                fx:controller="com.example.View2Controller"
                prefHeight="400.0" prefWidth="600.0">
        <Label
            fx:id="lData">
        </Label>

        <Button
            text="back"
            fx:id="btnBack">
        </Button>
    </AnchorPane>
    ```

## JavaFX Controllers

## JavaFX Starter Class

Create a Starter Class of our JavaFX called `GUI`:

```java

```