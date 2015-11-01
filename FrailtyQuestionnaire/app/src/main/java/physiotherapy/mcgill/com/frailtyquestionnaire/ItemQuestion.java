package physiotherapy.mcgill.com.frailtyquestionnaire;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class ItemQuestion {

    public String title;
    public String subtitle;
    public String subsubtitle;
    public String dbKey;
    public String[] options;
    public enum QuestionType {
        RNL
    }
    public QuestionType questionType;
    public Class questionClass;

    public ItemQuestion(QuestionType questionType, String title, String subtitle, String subsubtitle, String dbKey, String[] options){

        this.questionType = questionType;
        this.title = title;
        this.subtitle = subtitle;
        this.dbKey = dbKey;
        this.options = options;
        this.subsubtitle = subsubtitle;

    }

}
