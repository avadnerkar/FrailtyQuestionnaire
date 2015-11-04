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
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl1), null, new String[]{"RNL1"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl2), null, new String[]{"RNL2"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl3), null, new String[]{"RNL3"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl4), null, new String[]{"RNL4"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl5), null, new String[]{"RNL5"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl6), null, new String[]{"RNL6"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl7), null, new String[]{"RNL7"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl8), null, new String[]{"RNL8"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl9), null, new String[]{"RNL9"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl10), null, new String[]{"RNL10"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl11), null, new String[]{"RNL11"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        ItemSection rnlSection = new ItemSection(context.getString(R.string.rnl), rnlQuestions);

        ArrayList<ItemQuestion> barthelQuestions = new ArrayList<>();
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel1), null, null, new String[]{"Barthel1"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel2), null, null, new String[]{"Barthel2"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 0, 5}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel3), null, null, new String[]{"Barthel3"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 0, 5}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel4), null, null, new String[]{"Barthel4"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel5), null, null, new String[]{"Barthel5"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel6), null, null, new String[]{"Barthel6"}, new String[]{context.getString(R.string.complete), context.getString(R.string.occasional_accident), context.getString(R.string.complete_control)}, new int[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel7), null, null, new String[]{"Barthel7"}, new String[]{context.getString(R.string.complete), context.getString(R.string.occasional_accident), context.getString(R.string.complete_control)}, new int[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel8), null, null, new String[]{"Barthel8"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 10, 15}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel9), null, null, new String[]{"Barthel9"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 10, 15}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel10), null, null, new String[]{"Barthel10"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.RADIO_VERTICAL, context.getString(R.string.barthel11), null, null, new String[]{"Barthel11"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new int[]{0, 0, 10}));
        ItemSection barthelSection = new ItemSection(context.getString(R.string.barthel), barthelQuestions);

        ArrayList<ItemQuestion> oarsQuestions = new ArrayList<>();
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars1), null, null, new String[]{"OARS1"}, new String[]{context.getString(R.string.oars1_2), context.getString(R.string.oars1_1), context.getString(R.string.oars1_0)}, new int[]{2,1,0}));
        ItemSection oarsSection = new ItemSection(context.getString(R.string.oars), oarsQuestions);

        ArrayList<ItemQuestion> completion = new ArrayList<>();
        completion.add(new ItemQuestion(ItemQuestion.QuestionType.COMPLETION, null, null, null, null, null, null));
        ItemSection completionSection = new ItemSection(context.getString(R.string.finish), completion);

        sections = new ArrayList<>();
        sections.add(rnlSection);
        sections.add(barthelSection);
        sections.add(oarsSection);
        sections.add(completionSection);


    }

}
