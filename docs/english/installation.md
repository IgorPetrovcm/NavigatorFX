# Installation

__At the moment, the library has not been uploaded to any of the known public repositories.__

# Manual
Go to the root directory and run "mvn install". Then the necessary packages will be installed in the local repository.

If you want to exclude any modules, such as "fxml" or "mvvmfx", try:
```
mvn install -pl '!fxml`
```

OR

```
mvn install -pl '!fxml, !mvvmfx'
```
