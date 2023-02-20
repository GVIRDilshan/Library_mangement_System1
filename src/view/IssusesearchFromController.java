package view;

import com.jfoenix.controls.JFXTextField;
import controller.IssuseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import modal.Issuse;

public class IssusesearchFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblIssusId;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private Label lblIssuseDate;

    @FXML
    private Label lblMemberId;

    @FXML
    void onBack(ActionEvent event) {

    }
    @FXML
    void onSearch(ActionEvent event) {

        String searcId =txtSearch.getText();

        Issuse I1 = IssuseController.IssuseSearch(searcId);

        lblIssusId.setText(I1.getIssusId());
        lblIssuseDate.setText(I1.getIssusDate());
        lblMemberId.setText(I1.getMemberId());
    }
}