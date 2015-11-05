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
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel1), null, null, new String[]{"Barthel1"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel2), null, null, new String[]{"Barthel2"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 0, 5}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel3), null, null, new String[]{"Barthel3"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 0, 5}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel4), null, null, new String[]{"Barthel4"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel5), null, null, new String[]{"Barthel5"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel6), null, null, new String[]{"Barthel6"}, new String[]{context.getString(R.string.complete), context.getString(R.string.occasional_accident), context.getString(R.string.complete_control)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel7), null, null, new String[]{"Barthel7"}, new String[]{context.getString(R.string.complete), context.getString(R.string.occasional_accident), context.getString(R.string.complete_control)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel8), null, null, new String[]{"Barthel8"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 10, 15}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel9), null, null, new String[]{"Barthel9"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 10, 15}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel10), null, null, new String[]{"Barthel10"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel11), null, null, new String[]{"Barthel11"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 0, 10}));
        ItemSection barthelSection = new ItemSection(context.getString(R.string.barthel), barthelQuestions);

        ArrayList<ItemQuestion> oarsQuestions = new ArrayList<>();
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars1), null, null, new String[]{"OARS1"}, new String[]{context.getString(R.string.oars1_2), context.getString(R.string.oars1_1), context.getString(R.string.oars1_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars2), null, null, new String[]{"OARS2"}, new String[]{context.getString(R.string.oars2_2), context.getString(R.string.oars2_1), context.getString(R.string.oars2_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars3), null, null, new String[]{"OARS3"}, new String[]{context.getString(R.string.oars3_2), context.getString(R.string.oars3_1), context.getString(R.string.oars3_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars4), null, null, new String[]{"OARS4"}, new String[]{context.getString(R.string.oars4_2), context.getString(R.string.oars4_1), context.getString(R.string.oars4_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars5), null, null, new String[]{"OARS5"}, new String[]{context.getString(R.string.oars5_2), context.getString(R.string.oars5_1), context.getString(R.string.oars5_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars6), null, null, new String[]{"OARS6"}, new String[]{context.getString(R.string.oars6_2), context.getString(R.string.oars6_1), context.getString(R.string.oars6_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars7), null, null, new String[]{"OARS7"}, new String[]{context.getString(R.string.oars7_2), context.getString(R.string.oars7_1), context.getString(R.string.oars7_0)}, new Integer[]{2,1,0}));
        ItemSection oarsSection = new ItemSection(context.getString(R.string.oars), oarsQuestions);

        ArrayList<ItemQuestion> gdsQuestions = new ArrayList<>();
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds1), null, null, new String[]{"GDS1"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds2), null, null, new String[]{"GDS2"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds3), null, null, new String[]{"GDS3"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds4), null, null, new String[]{"GDS4"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds5), null, null, new String[]{"GDS5"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds6), null, null, new String[]{"GDS6"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds7), null, null, new String[]{"GDS7"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds8), null, null, new String[]{"GDS8"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        ItemSection gdsSection = new ItemSection(context.getString(R.string.gds), gdsQuestions);

        ArrayList<ItemQuestion> vahsQuestions = new ArrayList<>();
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs1), null, null, new String[]{"VAHS1"}, new String[]{context.getString(R.string.excellent), context.getString(R.string.poor)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs2), null, null, new String[]{"VAHS2"}, new String[]{context.getString(R.string.excellent), context.getString(R.string.poor)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs3), null, null, new String[]{"VAHS3"}, new String[]{context.getString(R.string.none), context.getString(R.string.much_distress)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs4), null, null, new String[]{"VAHS4"}, new String[]{context.getString(R.string.none), context.getString(R.string.much_pain)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs5), null, null, new String[]{"VAHS5"}, new String[]{context.getString(R.string.none), context.getString(R.string.much_fatigue)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs6), null, null, new String[]{"VAHS6"}, new String[]{context.getString(R.string.none), context.getString(R.string.much_depression)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE, context.getString(R.string.vahs7), null, null, new String[]{"VAHS7"}, new String[]{context.getString(R.string.none), context.getString(R.string.much_anxiety)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_REVERSE_EDIT, context.getString(R.string.vahs8), null, null, new String[]{"VAHS8", "VAHS_OTHER"}, new String[]{context.getString(R.string.none), context.getString(R.string.much)}, null));
        ItemSection vahsSection = new ItemSection(context.getString(R.string.vahs), vahsQuestions);

        ArrayList<ItemQuestion> completion = new ArrayList<>();
        completion.add(new ItemQuestion(ItemQuestion.QuestionType.COMPLETION, null, null, null, null, null, null));
        ItemSection completionSection = new ItemSection(context.getString(R.string.finish), completion);

        sections = new ArrayList<>();
        sections.add(rnlSection);
        sections.add(barthelSection);
        sections.add(oarsSection);
        sections.add(gdsSection);
        sections.add(vahsSection);
        sections.add(completionSection);


    }

}
