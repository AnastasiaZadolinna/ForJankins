package tests.api_by_Anastasia;

import java.util.UUID;

public class CategoryGroup {
    private UUID id;
    private String title;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "POJOCategory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
