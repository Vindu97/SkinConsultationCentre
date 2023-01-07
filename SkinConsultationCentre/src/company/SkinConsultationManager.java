package company;
import java.io.FileNotFoundException;
import java.util.List;

public interface SkinConsultationManager {

    void menuList();

    void doctorInput();

    void addDoctor(Doctor doctor);

    void doctorDelete( );

    void doctorsTable();

    void saveDetails();

    void recoverStats();

    void exit();
}
