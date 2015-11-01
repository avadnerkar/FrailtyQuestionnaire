package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class DataSource {

    public static ArrayList<ItemSection> sections;

    public static void init(Context context){

        ArrayList<ItemQuestion> rnlQuestions = new ArrayList<>();
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl1), null, "RNL1", null));
        ItemSection rnlSection = new ItemSection(context.getString(R.string.rnl), rnlQuestions);

        sections = new ArrayList<>();
        sections.add(rnlSection);

    }

}
