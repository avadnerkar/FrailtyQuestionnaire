package physiotherapy.mcgill.com.frailtyquestionnaire;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class ItemQuestion {

    public String title;
    public String subtitle;
    public String dbKey;
    public String[] options;
    public int view;

    public ItemQuestion(int view, String title, String subtitle, String dbKey, String[] options){

        this.view = view;
        this.title = title;
        this.subtitle = subtitle;
        this.dbKey = dbKey;
        this.options = options;

    }

}
