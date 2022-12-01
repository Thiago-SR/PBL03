module PBL03 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens app.controller to javafx.graphics, javafx.fxml;
	exports app;
}