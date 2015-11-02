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
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl1), null, "RNL1", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl2), null, "RNL2", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl3), null, "RNL3", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl4), null, "RNL4", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl5), null, "RNL5", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl6), null, "RNL6", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl7), null, "RNL7", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl8), null, "RNL8", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl9), null, "RNL9", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl10), null, "RNL10", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, context.getString(R.string.rnlTitle), context.getString(R.string.rnl11), null, "RNL11", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        ItemSection rnlSection = new ItemSection(context.getString(R.string.rnl), rnlQuestions);

        ArrayList<ItemQuestion> testQuestions = new ArrayList<>();
        testQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RNL, "Test", context.getString(R.string.rnl1), null, "TEST1", new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}));
        ItemSection testSection = new ItemSection("Test section", testQuestions);

        ArrayList<ItemQuestion> completion = new ArrayList<>();
        completion.add(new ItemQuestion(ItemQuestion.QuestionType.COMPLETION, null, null, null, null, null));
        ItemSection completionSection = new ItemSection(context.getString(R.string.finish), completion);

        sections = new ArrayList<>();
        sections.add(rnlSection);
        sections.add(testSection);
        sections.add(completionSection);

    }

}
