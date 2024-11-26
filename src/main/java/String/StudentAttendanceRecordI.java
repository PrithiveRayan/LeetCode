package String;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {

        if(s.contains("LLL")){
            return false;
        }
        int totalAbsent = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'A' && totalAbsent > 2){
                return false;
            }
            else if(s.charAt(i) == 'A'){
                totalAbsent++;
            }

        }
        return !(totalAbsent >= 2);
    }

    public static void main(String[] args) {

        StudentAttendanceRecordI sa = new StudentAttendanceRecordI();
//        System.out.println(sa.checkRecord("PPALLP"));
//        System.out.println(sa.checkRecord("PPALLL"));
        System.out.println(sa.checkRecord("AA"));
        System.out.println(sa.checkRecord("PPALLP"));

    }
}
