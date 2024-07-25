
package entity;

import constant.IConstant;
import java.util.List;
import util.Helper;
import util.Validate;


public class Fresher extends Candidate {
    //Lớp Fresher có các thuộc tính đặc trưng như graduationDate, education và graduationRank.
    //Các thuộc tính này được sử dụng để lưu trữ thông tin về thời gian tốt nghiệp, trình độ học vấn và xếp hạng tốt nghiệp của ứng viên.
    private int graduationDate;
    private String education;
    private String graduationRank;

    public Fresher() {
    }

    public Fresher(int id,
            String firstName,
            String lastName,
            int birthDate,
            String address,
            String phone,
            String email,
            int type,
            int graduationDate,
            String education,
            String graduationRank) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.graduationDate = graduationDate;
        this.education = education;
        this.graduationRank = graduationRank;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    private String getGraduationRank() {
        System.out.println(" 1. Excellence");
        System.out.println(" 2. Good");
        System.out.println(" 3. Fair");
        System.out.println(" 4. Poor");

        int choice = Validate.getInt(
                "Enter graduation rank: ",
                "Numeric value out of range.",
                "Invalid integer number.",
                1, 4);

        switch (choice) {
            case 1:
                return "Excellence";
            case 2:
                return "Good";
            case 3:
                return "Fair";
            case 4:
                return "Poor";

        }
        return null;

    }

    /**
     * setting fresher attributes through user input validation and set
     * candidate to fresher type
     *
     * @param list the list of candidates to check for duplicate IDs when
     * getting a new ID
     */
    @Override
    public void input(List<Candidate> list) {
        super.input(list);
        this.graduationDate = Validate.getInt(
                "Enter graduation time: ",
                "Numeric value out of range",
                "Invalid integer number",
                IConstant.MIN_YEAR,
                Helper.getCurrentYear());
        this.graduationRank = getGraduationRank(); // tại sao ngày tốt nghiện lại chỉ tính đến năm hiện tại 
        this.education = Validate.getString(
                "Enter education: ",
                "Invalid education",
                IConstant.REGEX_TEXT); // semester từ kỳ 1 - 9
        this.setType(IConstant.FRESHER_TYPE);
    }
}
