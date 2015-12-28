package physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers;

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
        TITLE, TITLE_LONG, SLIDER, COMPLETION, RADIO_VERTICAL, BUTTON_FLEXIBLE, SLIDER_REVERSE, SLIDER_EDIT, PLUS_MINUS, SMILEY, SLIDER_100, SLIDER_100_PERCENT, BUTTON_GRID,
        ANTHROPOMETRIC, GRIP_STRENGTH, VERTICAL_JUMP, BUTTON_FLEXIBLE_SCROLLABLE, SINGLE_FIELD, TEST_5_METRE, TEST_2_MIN
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
