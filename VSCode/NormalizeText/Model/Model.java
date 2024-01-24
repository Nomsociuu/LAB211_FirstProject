package LAB211.NormalizeText.Model;

public class Model {
    private String input;
    private String output;
    private String filename;

    public Model(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public Model() {

    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }
    
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getFileName() {
        return filename;
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }
}