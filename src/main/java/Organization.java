import java.time.LocalDate;

public class Organization {

    private long id;

    public void setId(long id) {
        this.id = id;
    }

    private String title;
    private String address;
    private LocalDate creationDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public Organization(String title, String address, LocalDate creationDate) {
        this.title = title;
        this.address = address;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
