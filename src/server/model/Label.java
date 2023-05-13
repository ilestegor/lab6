package server.model;

import common.validators.ModelValidator;

import java.io.Serializable;

/**
 * Model of Label, contains getters/setters for fields of class
 *
 * @author ilestegor
 */
public class Label implements Serializable {
    private String label;
    private final ModelValidator modelValidator = new ModelValidator();

    public Label(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        if (modelValidator.validateLabel(label)) {
            this.label = label;
        }
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
