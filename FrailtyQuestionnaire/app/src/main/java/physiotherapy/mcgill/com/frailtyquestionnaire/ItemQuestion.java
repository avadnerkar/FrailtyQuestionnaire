package physiotherapy.mcgill.com.frailtyquestionnaire;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class ItemQuestion {

    public String title;
    public String subtitle;
    public String subsubtitle;
    public String[] dbKey;
    public String[] options;
    public Object[] dbValues;
    public enum QuestionType {
        SLIDER, COMPLETION, RADIO_VERTICAL, BUTTON_FLEXIBLE, SLIDER_REVERSE, SLIDER_REVERSE_EDIT
    }
    public QuestionType questionType;
    public ItemQuestion(QuestionType questionType, String title, String subtitle, String subsubtitle, String[] dbKey, String[] options, Object[] dbValues){

        this.questionType = questionType;
        this.title = title;
        this.subtitle = subtitle;
        this.dbKey = dbKey;
        this.options = options;
        this.subsubtitle = subsubtitle;
        this.dbValues = dbValues;

    }

}
