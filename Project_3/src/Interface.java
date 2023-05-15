import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Interface {
    File file = null;

    static FileChooser fileChooser = new FileChooser();

    static TableView<Student> tableView = new TableView<>();

    static TableColumn<Student, Integer> IDColumn = new TableColumn<>("ID");
    static TableColumn<Student, Float> GPAColumn = new TableColumn<>("GPA");
    static TableColumn<Student, String> branchColumn = new TableColumn<>("Branch");

    static Button addStudentButton = new Button("Add Student");
    static Button removeStudentButton = new Button("Remove Student");
    static Button saveButton = new Button("Save");
    static Button loadButton = new Button("Browse");
    static Button updateStudentButton = new Button("Update");
    static Button findStudentButton = new Button("Find");
    static Button findGradeButton = new Button("Find Grade");

    static Label pathLabel = new Label("Path: ");

    static TextField pathTextField = new TextField();

    static HBox pathPane = new HBox(pathLabel, pathTextField, loadButton);

    static RadioButton scientificRadio = new RadioButton("Scientific");
    static RadioButton literaryRadio = new RadioButton("Literary");

    static ToggleGroup branchToggle = new ToggleGroup();

    static Button clearRadioButton = new Button("Clear");


    static HBox branchRadioPane = new HBox(scientificRadio, literaryRadio, clearRadioButton);


    static HBox buttonPane = new HBox(addStudentButton, removeStudentButton, updateStudentButton, findStudentButton, findGradeButton);
    static StackPane tablePane = new StackPane(tableView);
    static ButtonBar savePane = new ButtonBar();


    static Label IDLabel = new Label("ID: ");
    static TextField IDTextField = new TextField();
    static HBox addStudentIDPane = new HBox(IDLabel, IDTextField);
    static Label GPALabel = new Label("GPA: ");
    static TextField GPATextField = new TextField();
    static HBox GPAPane = new HBox(GPALabel, GPATextField);
    static Label branchLabel = new Label("Branch: ");
    static TextField branchTextField = new TextField();
    static HBox branchPane = new HBox(branchLabel, branchTextField);
    static Button addStudentButton2 = new Button("Add Student");
    static Button cancelAdd = new Button("Cancel");
    static HBox addStudentButtonPane = new HBox(addStudentButton2, cancelAdd);
    static Text addError = new Text("");
    static StackPane addErrorpane = new StackPane(addError);
    static VBox addStudentPage = new VBox(addStudentIDPane, GPAPane, branchPane, addStudentButtonPane, addErrorpane);
    static Scene addStudentScene = new Scene(addStudentPage, 300, 200);
    static Stage addStudentStage = new Stage();

    static Label removeIDLabel = new Label("ID: ");
    static TextField removeIDTextField = new TextField();

    static HBox removeStudentIDPane = new HBox(removeIDLabel, removeIDTextField);

    static Button removeStudentButton2 = new Button("Remove Student");
    static Button cancelRemove = new Button("Cancel");

    static HBox removeStudentButtonPane = new HBox(removeStudentButton2, cancelRemove);
    static Text removeError = new Text("");
    static StackPane removeErrorpane = new StackPane(removeError);

    static VBox removeStudentPage = new VBox(removeStudentIDPane, removeStudentButtonPane, removeErrorpane);

    static Scene removeStudentScene = new Scene(removeStudentPage, 300, 200);
    static Stage removeStudentStage = new Stage();

    static Label updateIDLabel = new Label("ID: ");
    static TextField updateIDTextField = new TextField();
    static Label newIDlabel = new Label("New ID: ");
    static TextField newIDTextField = new TextField();

    static HBox updateIDPane = new HBox(updateIDLabel, updateIDTextField);

    static HBox newIDPane = new HBox(newIDlabel, newIDTextField);

    static Label newGPALabel = new Label("New GPA: ");
    static TextField newGPATextField = new TextField();

    static HBox updateGPAPane = new HBox(newGPALabel, newGPATextField);

    static Label newBranchLabel = new Label("New Branch: ");
    static TextField newBranchTextField = new TextField();

    static HBox updateBranchPane = new HBox(newBranchLabel, newBranchTextField);

    static Button updateStudentButton2 = new Button("Update Student");

    static Button cancelUpdate = new Button("Cancel");
    static Text updateError = new Text("");
    static StackPane updateErrorpane = new StackPane(updateError);
    static HBox updateStudentButtonPane = new HBox(updateStudentButton2, cancelUpdate, updateErrorpane);

    static VBox updateStudentPage = new VBox(updateIDPane, newIDPane, updateGPAPane, updateBranchPane, updateStudentButtonPane);

    static Scene updateStudentScene = new Scene(updateStudentPage, 300, 200);

    static Stage updateStudentStage = new Stage();

    static Label findIDLabel = new Label("ID: ");
    static TextField findIDTextField = new TextField();

    static HBox findIDPane = new HBox(findIDLabel, findIDTextField);

    static Button findStudentButton2 = new Button("Find");
    static Button cancelFind = new Button("Cancel");

    static HBox findStudentButtonPane = new HBox(findStudentButton2, cancelFind);

    static Text findError = new Text("");
    static StackPane findErrorpane = new StackPane(findError);

    static VBox findStudentPage = new VBox(findIDPane, findStudentButtonPane, findErrorpane);

    static Scene findStudentScene = new Scene(findStudentPage, 300, 200);

    static Stage findStudentStage = new Stage();

    static Label findGradeLabel = new Label("Grade: ");
    static TextField findGradeTextField = new TextField();

    static HBox findGradePane = new HBox(findGradeLabel, findGradeTextField);

    static Button findGradeButton2 = new Button("Find");
    static Button cancelFindGrade = new Button("Cancel");

    static HBox findGradeButtonPane = new HBox(findGradeButton2, cancelFindGrade);
    static Text findGradeError = new Text("");
    static StackPane findGradeErrorpane = new StackPane(findGradeError);
    static VBox findGradePage = new VBox(findGradePane, findGradeButtonPane, findGradeErrorpane);

    static Scene findGradeScene = new Scene(findGradePage, 300, 200);

    static Stage findGradeStage = new Stage();

    static Button printGPATreeButton = new Button("Show GPA Tree Content");
    static Button printIDTreeButton = new Button("Show ID Tree Content");
    static Button printLinkedListButton = new Button("Show Linked List Content");
    static Button printHeighIDHeight = new Button("Show ID Tree Height");
    static Button printHeightGPATreeHeight = new Button("Show GPA Tree Height");

    static HBox heightButtonPane = new HBox(printHeighIDHeight, printHeightGPATreeHeight);
    static HBox printPane = new HBox(printGPATreeButton, printIDTreeButton, printLinkedListButton);
    static Label heightLabel = new Label("");

    static Button navPrevButton = new Button("Previous");
    static Button navNextButton = new Button("Next");
    static HBox navPane = new HBox(navPrevButton, navNextButton);
    static VBox mainPage = new VBox(branchRadioPane, pathPane, buttonPane, tablePane,navPane, printPane, heightButtonPane, heightLabel, savePane);


    static Scene scene = new Scene(mainPage, 700, 700);

//    static TextArea printRecords = new TextArea();





    Interface(){
        mainPage.setPadding(new Insets(10, 10, 10, 10));
        mainPage.setAlignment(Pos.CENTER);
        mainPage.setSpacing(20);

        pathTextField.setMinWidth(300);
        pathPane.setSpacing(20);
        pathPane.setAlignment(Pos.CENTER);

        scientificRadio.setToggleGroup(branchToggle);
        literaryRadio.setToggleGroup(branchToggle);
        branchRadioPane.setSpacing(20);
        branchRadioPane.setAlignment(Pos.CENTER);

        buttonPane.setSpacing(10);
        buttonPane.setAlignment(Pos.CENTER);

        tableView.getColumns().addAll(IDColumn, GPAColumn, branchColumn);

        savePane.getButtons().add(saveButton);

        addStudentPage.setSpacing(10);
//        addStudentPage.setAlignment(Pos.CENTER);
        addStudentPage.setPadding(new Insets(10, 10, 10, 10));
        addStudentIDPane.setSpacing(20);
        addStudentIDPane.setAlignment(Pos.CENTER);
        GPAPane.setSpacing(20);
        GPAPane.setAlignment(Pos.CENTER);
        branchPane.setSpacing(20);
        branchPane.setAlignment(Pos.CENTER);
        addStudentButtonPane.setSpacing(20);
        addStudentButtonPane.setAlignment(Pos.CENTER);
        addErrorpane.setAlignment(Pos.CENTER);
        addStudentStage.setTitle("Add Student");
        addStudentStage.setScene(addStudentScene);

        removeStudentPage.setSpacing(10);
        removeStudentPage.setPadding(new Insets(10, 10, 10, 10));
        removeStudentIDPane.setSpacing(20);
        removeStudentIDPane.setAlignment(Pos.CENTER);
        removeStudentButtonPane.setSpacing(20);
        removeStudentButtonPane.setAlignment(Pos.CENTER);
        removeErrorpane.setAlignment(Pos.CENTER);
        removeStudentStage.setTitle("Remove Student");
        removeStudentStage.setScene(removeStudentScene);

        updateStudentPage.setSpacing(10);
        updateStudentPage.setPadding(new Insets(10, 10, 10, 10));
        updateIDPane.setSpacing(20);
        updateIDPane.setAlignment(Pos.CENTER);
        newIDPane.setSpacing(20);
        newIDPane.setAlignment(Pos.CENTER);
        updateGPAPane.setSpacing(20);
        updateGPAPane.setAlignment(Pos.CENTER);
        updateBranchPane.setSpacing(20);
        updateBranchPane.setAlignment(Pos.CENTER);
        updateStudentButtonPane.setSpacing(20);
        updateStudentButtonPane.setAlignment(Pos.CENTER);
        updateErrorpane.setAlignment(Pos.CENTER);
        updateStudentStage.setTitle("Update Student");
        updateStudentStage.setScene(updateStudentScene);

        findStudentPage.setSpacing(10);
        findStudentPage.setPadding(new Insets(10, 10, 10, 10));
        findIDPane.setSpacing(20);
        findIDPane.setAlignment(Pos.CENTER);
        findStudentButtonPane.setSpacing(20);
        findStudentButtonPane.setAlignment(Pos.CENTER);
        findErrorpane.setAlignment(Pos.CENTER);
        findStudentStage.setTitle("Find Student");
        findStudentStage.setScene(findStudentScene);

        findGradePage.setSpacing(10);
        findGradePage.setPadding(new Insets(10, 10, 10, 10));
        findGradePane.setSpacing(20);
        findGradePane.setAlignment(Pos.CENTER);
        findGradeButtonPane.setSpacing(20);
        findGradeButtonPane.setAlignment(Pos.CENTER);
        findGradeErrorpane.setAlignment(Pos.CENTER);
        findGradeStage.setTitle("Find Grade");
        findGradeStage.setScene(findGradeScene);

        printPane.setSpacing(20);
        printPane.setAlignment(Pos.CENTER);

        navPane.setSpacing(20);
        navPane.setAlignment(Pos.CENTER);

        heightButtonPane.setSpacing(20);
        heightButtonPane.setAlignment(Pos.CENTER);

        addStudentButton.setDisable(true);
        removeStudentButton.setDisable(true);
        updateStudentButton.setDisable(true);
        findStudentButton.setDisable(true);
        findGradeButton.setDisable(true);
        printLinkedListButton.setDisable(true);
        printGPATreeButton.setDisable(true);
        printIDTreeButton.setDisable(true);
        saveButton.setDisable(true);
        printHeightGPATreeHeight.setDisable(true);
        printHeighIDHeight.setDisable(true);
        navPrevButton.setDisable(true);
        navNextButton.setDisable(true);



        branchColumn.setCellValueFactory(new PropertyValueFactory<>("branch"));
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        GPAColumn.setCellValueFactory(new PropertyValueFactory<>("GPA"));



        loadButton.setOnAction(e -> {
            file = fileChooser.showOpenDialog(Main.primaryStage);
            if (file != null) {
                pathTextField.setText(file.getAbsolutePath());
                try {
                    Main.tawjihiDS = new TawjihiDS(file);
                    tableView.setItems(Main.tawjihiDS.getObservableList());

                }
                catch (Exception ex){
                    System.out.println("Error reading records from file");
                    System.out.println(ex.getMessage());
                }
                if(Main.tawjihiDS.students.getSize() > 0) {
                    addStudentButton.setDisable(false);
                    removeStudentButton.setDisable(false);
                    updateStudentButton.setDisable(false);
                    findStudentButton.setDisable(false);
                    findGradeButton.setDisable(false);
                    printLinkedListButton.setDisable(false);
                    printGPATreeButton.setDisable(false);
                    printIDTreeButton.setDisable(false);
                    saveButton.setDisable(false);
                    printHeightGPATreeHeight.setDisable(false);
                    printHeighIDHeight.setDisable(false);
                    navPrevButton.setDisable(false);
                    navNextButton.setDisable(false);
                }
                else {
                    addStudentButton.setDisable(true);
                    removeStudentButton.setDisable(true);
                    updateStudentButton.setDisable(true);
                    findStudentButton.setDisable(true);
                    findGradeButton.setDisable(true);
                    printLinkedListButton.setDisable(true);
                    printGPATreeButton.setDisable(true);
                    printIDTreeButton.setDisable(true);
                    saveButton.setDisable(true);
                    printHeightGPATreeHeight.setDisable(true);
                    printHeighIDHeight.setDisable(true);
                    navPrevButton.setDisable(true);
                    navNextButton.setDisable(true);
                }
            }
            else {
                addStudentButton.setDisable(true);
                removeStudentButton.setDisable(true);
                updateStudentButton.setDisable(true);
                findStudentButton.setDisable(true);
                findGradeButton.setDisable(true);
                printLinkedListButton.setDisable(true);
                printGPATreeButton.setDisable(true);
                printIDTreeButton.setDisable(true);
                saveButton.setDisable(true);
                printHeightGPATreeHeight.setDisable(true);
                printHeighIDHeight.setDisable(true);
                navPrevButton.setDisable(false);
                navNextButton.setDisable(false);
            }

        });

        addStudentButton.setOnAction(e -> {
            addStudentStage.setScene(addStudentScene);
            addStudentStage.show();
        });
        addStudentButton2.setOnAction(e -> {
            try {
                int id = Integer.parseInt(IDTextField.getText());
                if (id < 0){
                    addError.setText("ID must be positive!");
                    return;
                }
                if (checkForDuplicateID(id)){
                    addError.setText("ID already exists!");
                    return;
                }
                float gpa = Float.parseFloat(GPATextField.getText());
                if (gpa > 100 || gpa < 0){
                    addError.setText("GPA must be between 0 and 100!");
                    return;
                }
                String branch = branchTextField.getText();
                if (branch.equalsIgnoreCase("Literary")) branch = "Literary";
                else if (branch.equalsIgnoreCase("Scientific")) branch = "Scientific";
                else {addError.setText("Branch must be either Literary or Scientific!");
                    return;
                }
                Main.tawjihiDS.insert(new Student(id, branch, gpa));
                tableView.setItems(Main.tawjihiDS.getObservableList());
                addStudentStage.close();
            }
            catch (Exception ex){
                addError.setText("Invalid ID or GPA!");
                System.out.println(ex.getMessage() + " " + ex);
            }
        });

        cancelAdd.setOnAction(e -> {
            addStudentStage.close();
        });

        removeStudentButton.setOnAction(e -> {
            removeStudentStage.show();
        });

        removeStudentButton2.setOnAction(e -> {
            try {
                int id = Integer.parseInt(removeIDTextField.getText());
                System.out.println(id);
                if (id < 0) {
                    addError.setText("ID must be positive!");
                    return;
                }
                if (Main.tawjihiDS.removeStudent(id) == false) {
                    removeError.setText("ID not found!");
                    return;
                }
                tableView.setItems(Main.tawjihiDS.getObservableList());
                addStudentStage.close();
            }
            catch (Exception ex){
                removeError.setText("Invalid ID");
                System.out.println(ex.getStackTrace());
            }
        });

        cancelRemove.setOnAction(e -> {
            removeStudentStage.close();
        });

        updateStudentButton.setOnAction(e -> {
            updateStudentStage.show();
        });

        updateStudentButton2.setOnAction(e -> {
            try {
                int id = Integer.parseInt(updateIDTextField.getText());
                if (id < 0) {
                    addError.setText("ID must be positive!");
                    return;
                }
                if (!checkForDuplicateID(id)){
                    updateError.setText("ID doesn't exist!");
                    return;
                }
                int newID = Integer.parseInt(newIDTextField.getText());
                if (newID < 0){
                    updateError.setText("ID must be positive!");
                    return;
                }
                if (checkForDuplicateID(newID)){
                    updateError.setText("ID already exists!");
                    return;
                }
                float gpa = Float.parseFloat(newGPATextField.getText());
                if (gpa > 100 || gpa < 0){
                    updateError.setText("GPA must be between 0 and 100!");
                    return;
                }
                String branch = newBranchTextField.getText();
                if (branch.equalsIgnoreCase("Literary")) branch = "Literary";
                else if (branch.equalsIgnoreCase("Scientific")) branch = "Scientific";
                else {updateError.setText("Branch must be either Literary or Scientific!");
                    return;
                }
                Main.tawjihiDS.removeStudent(id);
                Main.tawjihiDS.insert(new Student(id, branch, gpa));
                tableView.setItems(Main.tawjihiDS.getObservableList());
                updateStudentStage.close();
            }
            catch (Exception ex){
                addError.setText("Invalid ID or GPA!");
                System.out.println(ex.getMessage() + " " + ex);
            }
        });

        cancelUpdate.setOnAction(e -> {
            updateStudentStage.close();
        });

        findStudentButton.setOnAction(e -> {
            findStudentStage.show();
        });

        findStudentButton2.setOnAction(e -> {
            try {
                int id = Integer.parseInt(findIDTextField.getText());
                if (id < 0) {
                    findError.setText("ID must be positive!");
                    return;
                }
                if (!checkForDuplicateID(id)){
                    findError.setText("ID doesn't exist!");
                    return;
                }
                if (Main.tawjihiDS.exist(id)) {
                    Student st = Main.tawjihiDS.find(id);
                    tableView.getItems().clear();
                    tableView.getItems().add(st);
                };
                findStudentStage.close();
            } catch (Exception ex) {
                findError.setText("Invalid ID");
                System.out.println(ex.getStackTrace());
            }
        });
        cancelFind.setOnAction(e -> {
            findStudentStage.close();
        });

        findGradeButton.setOnAction(e -> {
            findGradeStage.show();

        });

        findGradeButton2.setOnAction(e -> {
            try {
                float grade = Float.parseFloat(findGradeTextField.getText());
                if (grade > 100 || grade < 0){
                    findGradeError.setText("GPA must be between 0 and 100!");
                    return;
                }
                tableView.getItems().clear();
                LnNode node = Main.tawjihiDS.GPAs.find(grade).getFirst();
                for(int i = 0; i < Main.tawjihiDS.GPAs.size; i++){
                    tableView.getItems().add(node.getStudent());
                    node = node.next;
                }
                findGradeStage.close();
            }
            catch (Exception ex){
                findGradeError.setText("Invalid GPA!");
                System.out.println(ex.getMessage() + " " + ex);
            }
            findGradeStage.close();
        });

        cancelFindGrade.setOnAction(e -> {
            findGradeStage.close();
        });

        printGPATreeButton.setOnAction(e -> {
            //TODO
            Student [] gradesList = Main.tawjihiDS.GPAs.traverseLevelOrder();
            tableView.getItems().clear();
            for (int i = 0; i < gradesList.length; i++) {
               tableView.getItems().add(gradesList[i]);
            }

        });

        printIDTreeButton.setOnAction(e -> {
           Student [] idsList = Main.tawjihiDS.IDs.traverseLevelOrder();
            tableView.getItems().clear();
            for (int i = 0; i < idsList.length; i++) {
               tableView.getItems().add(idsList[i]);
            }
        });



        printLinkedListButton.setOnAction(e -> {
            tableView.getItems().clear();
            DoubleNode node = Main.tawjihiDS.students.getFirst();
            for (int i =0 ; i < Main.tawjihiDS.students.getSize(); i++){
                tableView.getItems().add(node.getStudent());
                node = node.next;
            }
        });

        printHeighIDHeight.setOnAction(e -> {
            int height = Main.tawjihiDS.IDs.getHeight();
            heightLabel.setText("Height: " + height);
        });

        printHeightGPATreeHeight.setOnAction(e -> {
            int height = Main.tawjihiDS.GPAs.getHeight();
            heightLabel.setText("Height: " + height);
        });

        navNextButton.setOnAction(e -> {
            if (Main.tawjihiDS.students.getSize() == 0) return;
            DoubleNode node = Main.tawjihiDS.IDs.find(tableView.getItems().get(0).getID());
            tableView.getItems().clear();
            tableView.getItems().add(node.next.getStudent());
        });

        navPrevButton.setOnAction(e -> {
            if (Main.tawjihiDS.students.getSize() == 0) return;
            DoubleNode node = Main.tawjihiDS.IDs.find(tableView.getItems().get(0).getID());
            tableView.getItems().clear();
            tableView.getItems().add(node.prev.getStudent());
        });

        clearRadioButton.setOnAction(e -> {
            literaryRadio.setSelected(false);
            scientificRadio.setSelected(false);
        });

        saveButton.setOnAction(e -> {
            //TODO
            try {
                Main.tawjihiDS.saveToFile(pathTextField.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    private boolean checkForDuplicateID(int id) {
        if (Main.tawjihiDS.students.getSize() == 0) return false;
        return (Main.tawjihiDS.exist(id));
    }


}
