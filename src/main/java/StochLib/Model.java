package StochLib;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;
    private String lineVersion;

    public Model(String modelName) {
        this.name = modelName;
        this.lineVersion = "3.0.0";
    }

    public String getName() {
        return this.name;
    }
    public void setName(String setName) {
        this.name = setName;
    }
    public String getLineVersion() { return this.lineVersion; }
}