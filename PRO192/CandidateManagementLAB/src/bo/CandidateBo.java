package bo;

import constant.IConstant;
import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import java.util.List;
import util.Helper;

public class CandidateBo {

    private List<Candidate> list;

    public CandidateBo(List<Candidate> list) {
        this.list = list;
    }

    /**
     * Create a new candidate object and add it to this list of candidates
     *
     * @param type the type to distinct experience among fresher and intern
     */
    public void add(int type) {
        Candidate candidate = null;
        do {
            switch (type) {
                case IConstant.EXPERIENCE_TYPE:
                    candidate = new Experience();
                    break;
                case IConstant.FRESHER_TYPE:
                    candidate = new Fresher();
                    break;
                case IConstant.INTERN_TYPE:
                    candidate = new Intern();
                    break;
            }
            if (candidate != null) {
                candidate.input(list);
                this.list.add(candidate);
            } else {
                System.out.println(
                        "An error has occurred. Can not add new candidate");
            }
        } while (Helper.isContinue());
    }

    /**
     * Searches candidates for a given name and type.
     *
     * @param searchName the name to search for
     * @param type the type of candidate to search for
     * @return list of candidates that match the given name and type
     */
    public List<Candidate> search(String searchName, int type) {
//        return this.list.stream()
//                .filter(c -> (c.getFullName().toUpperCase()).contains(searchName.toUpperCase()))
//                .filter(c -> c.getType() == type)
//                .collect(Collectors.toList());
        List<Candidate> result = new ArrayList<>();
        for (Candidate candidate : this.list) {
            String fullName = candidate.getFullName();
            if (fullName != null) {
                fullName = fullName.toUpperCase();
                searchName = searchName.toUpperCase();

                if (fullName.contains(searchName) && candidate.getType() == type) {
                    result.add(candidate);
                }
            }
        }

        return result;
    } // filter() của Stream để lọc ra các ứng viên có tên chứa chuỗi searchName bằng cách sử dụng phương thức getFullName() của lớp Candidate.

    /**
     * display all candidates information in the list
     *
     * @param list the list of candidate to display
     */
    public void display(List<Candidate> list) {
        if (list.isEmpty()) {
            System.out.println("\n Not Found");
        } else {
            System.out.println("\n The candidate found ");
            System.out.printf("%-5s %-20s %-20s %-10s %-30s %-15s %-30s %-10s%n", "ID", "First Name", "Last Name",
                    "Birth Date", "Address", "Phone", "Email", "Type");
            list.forEach((candidate) -> {// forEach lặp qua mọi phần tử trong luồng
                candidate.display();     // hiển thị từng thành viên trong candidate
            });
        }
    }
    //    Phương thức này sử dụng phương thức stream() của lớp List để tạo một luồng dữ liệu cho danh sách các ứng viên.
    //Sau đó, phương thức sử dụng phương thức filter() của Stream để lọc ra các ứng viên có kiểu ứng viên trùng với kiểu được truyền vào.
    //Cuối cùng, phương thức sử dụng phương thức forEach() của Stream để hiển thị
    //tên đầy đủ của mỗi ứng viên tương ứng bằng cách sử dụng phương thức getFullName() của lớp Candidate.

    /**
     * Displays the full names of candidates with the specified type.
     *
     * @param TYPE the type of candidates to display
     */
    public void displayCandidateNameByType(final int TYPE) {
//        this.list.stream()
//                .filter(c -> c.getType() == TYPE)
//                .forEach(c -> System.out.println(c.getFullName()));
        for (Candidate candidate : this.list) {
            if (candidate.getType() == TYPE) {
                System.out.println(candidate.getFullName());
            }
        }
    }

}
