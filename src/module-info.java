module Zoo_Management_System {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml ,javafx.base;
}
