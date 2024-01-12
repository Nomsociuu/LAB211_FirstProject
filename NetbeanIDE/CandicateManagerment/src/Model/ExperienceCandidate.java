package Model;

public class ExperienceCandidate extends Candidate {
    private int expInYear;
    private String proSkill;

    public ExperienceCandidate() {
    }
    

    public ExperienceCandidate(String candidateId, String firstName, String lastName, String birthDate,
                               String address, String phone, String email, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String getCandidateInfo() {
        return super.getCandidateInfo() + String.format("");//" | %d | %s", expInYear, proSkill
    }
}
