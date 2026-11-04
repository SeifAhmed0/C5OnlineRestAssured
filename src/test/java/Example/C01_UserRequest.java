package Example;

import java.util.List;

public class C01_UserRequest {
    private String name;
    private String job;
    private List<String> skills;
    private C02_Address address;
    private C03_Contact contact;

    public C02_Address getAddress() {
        return address;
    }

    public void setAddress(C02_Address address) {
        this.address = address;
    }

    public C03_Contact getContact() {
        return contact;
    }

    public void setContact(C03_Contact contact) {
        this.contact = contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public List<String> getSkills() {
        return skills;
    }
}
