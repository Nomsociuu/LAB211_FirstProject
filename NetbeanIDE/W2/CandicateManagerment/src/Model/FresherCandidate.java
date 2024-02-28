package Model;

public class FresherCandidate extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate(String candidateId, String firstName, String lastName, String birthDate,
                            String address, String phone, String email, String graduationDate,
                            String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String getCandidateInfo() {
        return super.getCandidateInfo() + String.format("");// | %s | %s | %s
    }
}