package homework01_Test;

public class Menu {
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void Show() {
        System.out.printf("%-15s | %s\n", name, description);
    }
}