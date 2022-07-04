import java.time.LocalDate;
import java.util.HashMap;

public class OrganizationRepository {

    private long maxId;
    private HashMap<Long, Organization> organizations;

    private static OrganizationRepository instance = null;
    public static OrganizationRepository getInstance() {

        if (instance == null) {
            instance = new OrganizationRepository();
        }

        return instance;
    }

    private OrganizationRepository() {

        maxId = 0;
        organizations = new HashMap<>();

        for (int i=0;i<3;i++) {
            create(new Organization("title #" + i, "address #" + i, LocalDate.now()));
        }
    }

    public long create(Organization organization) {

        maxId += 1;
        organization.setId(maxId);
        organizations.put(maxId, organization);
        return maxId;
    }

    public HashMap<Long, Organization> getAll() {

        return organizations;
    }


    public void delete(Long id) {

        organizations.remove(id);
    }
}
