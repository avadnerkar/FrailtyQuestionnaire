package physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers;

import android.content.Context;

import java.util.ArrayList;

import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class DataSource {

    public static ArrayList<ItemSection> sections;
    public static ItemSection barthelSection;
    public static ItemSection oarsSection;
    public static ItemSection gdsSection;
    public static ItemSection vahsSection;
    public static ItemSection fallSection;
    public static ItemSection moodSection;
    public static ItemSection appetiteSection;
    public static ItemSection drivingSection;
    public static ItemSection walkingSection;
    public static ItemSection dizzySection;
    public static ItemSection urineSection;
    public static ItemSection euroSection;
    public static ItemSection healthStateSection;
    public static ItemSection completionSection;
    public static ItemSection rnlEffortSection;
    public static ItemSection rnlRestrictionSection;
    public static ItemSection raschSection;
    public static ItemSection rand36Section;
    public static ItemSection abcSection;
    public static ItemSection lsmSection;
    public static ItemSection pdqSection;
    public static ItemSection anthropometricSection;
    public static void init(Context context){

        ArrayList<ItemQuestion> barthelQuestions = new ArrayList<>();
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.barthel), null, null, null, null, null));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel1), null, null, new String[]{"Barthel1"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.partially), context.getString(R.string.completely)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel2), null, null, new String[]{"Barthel2"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.partially), context.getString(R.string.completely)}, new Integer[]{0, 0, 5}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel3), null, null, new String[]{"Barthel3"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.partially), context.getString(R.string.completely)}, new Integer[]{0, 0, 5}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel4), null, null, new String[]{"Barthel4"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.partially), context.getString(R.string.completely)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel5), null, null, new String[]{"Barthel5"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.partially), context.getString(R.string.completely)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel6), null, null, new String[]{"Barthel6"}, new String[]{context.getString(R.string.complete), context.getString(R.string.occasional_accident), context.getString(R.string.complete_control)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel7), null, null, new String[]{"Barthel7"}, new String[]{context.getString(R.string.complete), context.getString(R.string.occasional_accident), context.getString(R.string.complete_control)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel8), null, null, new String[]{"Barthel8"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 10, 15}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel9), null, null, new String[]{"Barthel9"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 10, 15}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel10), null, null, new String[]{"Barthel10"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 5, 10}));
        barthelQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.barthel11), null, null, new String[]{"Barthel11"}, new String[]{context.getString(R.string.unable), context.getString(R.string.needs_assistance), context.getString(R.string.fully_independent)}, new Integer[]{0, 0, 10}));
        barthelSection = new ItemSection(context.getString(R.string.barthel), barthelQuestions);

        ArrayList<ItemQuestion> oarsQuestions = new ArrayList<>();
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.oars), null, null, null, null, null));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars1), null, null, new String[]{"OARS1"}, new String[]{context.getString(R.string.oars1_2), context.getString(R.string.oars1_1), context.getString(R.string.oars1_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars2), null, null, new String[]{"OARS2"}, new String[]{context.getString(R.string.oars2_2), context.getString(R.string.oars2_1), context.getString(R.string.oars2_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars3), null, null, new String[]{"OARS3"}, new String[]{context.getString(R.string.oars3_2), context.getString(R.string.oars3_1), context.getString(R.string.oars3_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars4), null, null, new String[]{"OARS4"}, new String[]{context.getString(R.string.oars4_2), context.getString(R.string.oars4_1), context.getString(R.string.oars4_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars5), null, null, new String[]{"OARS5"}, new String[]{context.getString(R.string.oars5_2), context.getString(R.string.oars5_1), context.getString(R.string.oars5_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars6), null, null, new String[]{"OARS6"}, new String[]{context.getString(R.string.oars6_2), context.getString(R.string.oars6_1), context.getString(R.string.oars6_0)}, new Integer[]{2,1,0}));
        oarsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.oars7), null, null, new String[]{"OARS7"}, new String[]{context.getString(R.string.oars7_2), context.getString(R.string.oars7_1), context.getString(R.string.oars7_0)}, new Integer[]{2,1,0}));
        oarsSection = new ItemSection(context.getString(R.string.oars), oarsQuestions);

        ArrayList<ItemQuestion> gdsQuestions = new ArrayList<>();
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.gds), null, null, null, null, null));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds1), null, null, new String[]{"GDS1"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds2), null, null, new String[]{"GDS2"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds3), null, null, new String[]{"GDS3"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds4), null, null, new String[]{"GDS4"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds5), null, null, new String[]{"GDS5"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds6), null, null, new String[]{"GDS6"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds7), null, null, new String[]{"GDS7"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.gds8), null, null, new String[]{"GDS8"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}));
        gdsSection = new ItemSection(context.getString(R.string.gds), gdsQuestions);

        ArrayList<ItemQuestion> vahsQuestions = new ArrayList<>();
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.vahs), null, null, null, null, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs1), null, null, new String[]{"VAHS1"}, new String[]{context.getString(R.string.poor), context.getString(R.string.excellent)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs2), null, null, new String[]{"VAHS2"}, new String[]{context.getString(R.string.poor), context.getString(R.string.excellent)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs3), null, null, new String[]{"VAHS3"}, new String[]{context.getString(R.string.much_distress), context.getString(R.string.none)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs4), null, null, new String[]{"VAHS4"}, new String[]{context.getString(R.string.much_pain), context.getString(R.string.none)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs5), null, null, new String[]{"VAHS5"}, new String[]{context.getString(R.string.much_fatigue), context.getString(R.string.none)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs6), null, null, new String[]{"VAHS6"}, new String[]{context.getString(R.string.much_depression), context.getString(R.string.none)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.vahs7), null, null, new String[]{"VAHS7"}, new String[]{context.getString(R.string.much_anxiety), context.getString(R.string.none)}, null));
        vahsQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_EDIT, context.getString(R.string.vahs8), null, null, new String[]{"VAHS8", "VAHS_OTHER"}, new String[]{context.getString(R.string.much), context.getString(R.string.none)}, null));
        vahsSection = new ItemSection(context.getString(R.string.vahs), vahsQuestions);

        ArrayList<ItemQuestion> falls = new ArrayList<>();
        falls.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.falls), null, null, null, null, null));
        falls.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.falls1), null, null, new String[]{"NumFalls"}, new String[]{context.getString(R.string.one), context.getString(R.string.two), context.getString(R.string.three), context.getString(R.string.four_or_more)}, new String[]{"1", "2", "3", "4 or more"}));
        falls.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.falls2), null, null, new String[]{"FallOutcome"}, new String[]{context.getString(R.string.injury_treatment), context.getString(R.string.injury_without_treatment), context.getString(R.string.no_injury), context.getString(R.string.no_falls)}, new String[]{"InjuryWithTreatment", "InjuryWithoutTreatment", "NoInjury", "NoFalls"}));
        fallSection = new ItemSection(context.getString(R.string.falls), falls);

        ArrayList<ItemQuestion> mood = new ArrayList<>();
        mood.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.moodTitle), null, null, null, null, null));
        mood.add(new ItemQuestion(ItemQuestion.QuestionType.SMILEY, context.getString(R.string.motivation), null, null, new String[]{"Motivation"}, null, null));
        mood.add(new ItemQuestion(ItemQuestion.QuestionType.SMILEY, context.getString(R.string.mood), null, null, new String[]{"Mood"}, null, null));
        mood.add(new ItemQuestion(ItemQuestion.QuestionType.SMILEY, context.getString(R.string.pain), null, null, new String[]{"Pain"}, null, null));
        mood.add(new ItemQuestion(ItemQuestion.QuestionType.SMILEY, context.getString(R.string.fatigue), null, null, new String[]{"Fatigue"}, null, null));
        moodSection = new ItemSection(context.getString(R.string.moodTitle), mood);


        ArrayList<ItemQuestion> appetite = new ArrayList<>();
        appetite.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.appetite), null, null, null, null, null));
        appetite.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.appetite1), null, null, new String[]{"Appetite1"}, new String[]{context.getString(R.string.very_poor), context.getString(R.string.poor), context.getString(R.string.average), context.getString(R.string.good), context.getString(R.string.very_good)}, null));
        appetite.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.appetite2), null, null, new String[]{"Appetite2"}, new String[]{context.getString(R.string.appetite2_1), context.getString(R.string.appetite2_2), context.getString(R.string.appetite2_3), context.getString(R.string.appetite2_4), context.getString(R.string.appetite2_5)}, null));
        appetite.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.appetite3), null, null, new String[]{"Appetite3"}, new String[]{context.getString(R.string.very_bad), context.getString(R.string.bad), context.getString(R.string.average), context.getString(R.string.good), context.getString(R.string.very_good)}, null));
        appetite.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.appetite4), null, null, new String[]{"Appetite4"}, new String[]{context.getString(R.string.meals0), context.getString(R.string.meals1), context.getString(R.string.meals2), context.getString(R.string.meals3), context.getString(R.string.meals4)}, null));
        appetiteSection = new ItemSection(context.getString(R.string.appetite), appetite);

        ArrayList<ItemQuestion> driving = new ArrayList<>();
        driving.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.driving), null, null, null, null, null));
        driving.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.driving1), null, null, new String[]{"Driving1"}, new String[]{context.getString(R.string.driving1_1), context.getString(R.string.driving1_2), context.getString(R.string.driving1_3), context.getString(R.string.driving1_4)}, null));
        drivingSection = new ItemSection(context.getString(R.string.driving), driving);

        ArrayList<ItemQuestion> walking = new ArrayList<>();
        walking.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.walking), null, null, null, null, null));
        walking.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.walking), null, null, new String[]{"Walking1"}, new String[]{context.getString(R.string.walking1_1), context.getString(R.string.walking1_2), context.getString(R.string.walking1_3), context.getString(R.string.walking1_4), context.getString(R.string.walking1_5), context.getString(R.string.walking1_6)}, null));
        walkingSection = new ItemSection(context.getString(R.string.walking), walking);

        ArrayList<ItemQuestion> dizzy = new ArrayList<>();
        dizzy.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.dizzy), null, null, null, null, null));
        dizzy.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.dizzy1), null, null, new String[]{"Dizzy1"}, new String[]{context.getString(R.string.yes), context.getString(R.string.no)}, null));
        dizzy.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.dizzy2), null, null, new String[]{"Dizzy2"}, new String[]{context.getString(R.string.dizzy2_1), context.getString(R.string.dizzy2_2), context.getString(R.string.dizzy2_3), context.getString(R.string.dizzy2_4), context.getString(R.string.dizzy2_5)}, null));
        dizzySection = new ItemSection(context.getString(R.string.dizzy), dizzy);

        ArrayList<ItemQuestion> urine = new ArrayList<>();
        urine.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.urine), null, null, null, null, null));
        urine.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.urine1), null, null, new String[]{"ICIQ1"}, new String[]{context.getString(R.string.urine1_1), context.getString(R.string.urine1_2), context.getString(R.string.urine1_3), context.getString(R.string.urine1_4), context.getString(R.string.urine1_5), context.getString(R.string.urine1_6)}, new Integer[]{0, 1, 2, 3, 4, 5}));
        urine.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.urine2), null, null, new String[]{"ICIQ2"}, new String[]{context.getString(R.string.urine2_1), context.getString(R.string.urine2_2), context.getString(R.string.urine2_3), context.getString(R.string.urine2_4)}, new Integer[]{0, 2, 4, 6}));
        urine.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.urine3), null, null, new String[]{"ICIQ3"}, new String[]{context.getString(R.string.a_great_deal), context.getString(R.string.not_at_all)}, null));
        urineSection = new ItemSection(context.getString(R.string.urine), urine);

        ArrayList<ItemQuestion> euro = new ArrayList<>();
        euro.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.euro), context.getString(R.string.euroDescription), null, null, null, null));
        euro.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.euro1), null, null, new String[]{"EURO1"}, new String[]{context.getString(R.string.euro1_1), context.getString(R.string.euro1_2), context.getString(R.string.euro1_3)}, new Integer[]{2,1,0}));
        euro.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.euro2), null, null, new String[]{"EURO2"}, new String[]{context.getString(R.string.euro2_1), context.getString(R.string.euro2_2), context.getString(R.string.euro2_3)}, new Integer[]{2,1,0}));
        euro.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.euro3), null, null, new String[]{"EURO3"}, new String[]{context.getString(R.string.euro3_1), context.getString(R.string.euro3_2), context.getString(R.string.euro3_3)}, new Integer[]{2,1,0}));
        euro.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.euro4), null, null, new String[]{"EURO4"}, new String[]{context.getString(R.string.euro4_1), context.getString(R.string.euro4_2), context.getString(R.string.euro4_3)}, new Integer[]{2,1,0}));
        euro.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.euro5), null, null, new String[]{"EURO5"}, new String[]{context.getString(R.string.euro5_1), context.getString(R.string.euro5_2), context.getString(R.string.euro5_3)}, new Integer[]{2,1,0}));
        euroSection = new ItemSection(context.getString(R.string.euro), euro);

        ArrayList<ItemQuestion> healthState = new ArrayList<>();
        healthState.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE_LONG, context.getString(R.string.health_state), context.getString(R.string.health_state_description), null, null, null, null));
        healthState.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100, context.getString(R.string.health_state_title), null, null, new String[]{"HealthState"}, new String[]{context.getString(R.string.health_state_worst), context.getString(R.string.health_state_best)}, null));
        healthStateSection = new ItemSection(context.getString(R.string.health_state), healthState);

        ArrayList<ItemQuestion> rnlEffortQuestions = new ArrayList<>();
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE_LONG, context.getString(R.string.rnl), context.getString(R.string.rnlDescription), null, null, null, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl1), null, new String[]{"RNLEffort1"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl2), null, new String[]{"RNLEffort2"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl3), null, new String[]{"RNLEffort3"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl4), null, new String[]{"RNLEffort4"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl5), null, new String[]{"RNLEffort5"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl6), null, new String[]{"RNLEffort6"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl7), null, new String[]{"RNLEffort7"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl8), null, new String[]{"RNLEffort8"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl9), null, new String[]{"RNLEffort9"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl10), null, new String[]{"RNLEffort10"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlTitle), context.getString(R.string.rnl11), null, new String[]{"RNLEffort11"}, new String[]{context.getString(R.string.rnlOption1), context.getString(R.string.rnlOption2)}, null));
        rnlEffortSection = new ItemSection(context.getString(R.string.rnl), rnlEffortQuestions);

        ArrayList<ItemQuestion> rnlRestrictionQuestions = new ArrayList<>();
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE_LONG, context.getString(R.string.rnlRestriction), context.getString(R.string.rnlRestrictionDescription), null, null, null, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction1), null, new String[]{"RNLRestriction1"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction2), null, new String[]{"RNLRestriction2"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction3), null, new String[]{"RNLRestriction3"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction4), null, new String[]{"RNLRestriction4"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction5), null, new String[]{"RNLRestriction5"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction6), null, new String[]{"RNLRestriction6"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction7), null, new String[]{"RNLRestriction7"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction8), null, new String[]{"RNLRestriction8"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction9), null, new String[]{"RNLRestriction9"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction10), null, new String[]{"RNLRestriction10"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionQuestions.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER, context.getString(R.string.rnlRestrictionTitle), context.getString(R.string.rnlRestriction11), null, new String[]{"RNLRestriction11"}, new String[]{context.getString(R.string.rnlRestrictionOption1), context.getString(R.string.rnlRestrictionOption2)}, null));
        rnlRestrictionSection = new ItemSection(context.getString(R.string.rnlRestriction), rnlRestrictionQuestions);

        ArrayList<ItemQuestion> rasch = new ArrayList<>();
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.rasch), null, null, null, null, null));
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rasch1), null, null, new String[]{"RaschMotivation1"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.slightly), context.getString(R.string.some), context.getString(R.string.a_lot)}, new Integer[]{0,1,2,3}));
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rasch2), null, null, new String[]{"RaschMotivation2"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.slightly), context.getString(R.string.some), context.getString(R.string.a_lot)}, new Integer[]{0,1,2,3}));
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rasch3), null, null, new String[]{"RaschMotivation3"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.slightly), context.getString(R.string.some), context.getString(R.string.a_lot)}, new Integer[]{0,1,2,3}));
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rasch4), null, null, new String[]{"RaschMotivation4"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.slightly), context.getString(R.string.some), context.getString(R.string.a_lot)}, new Integer[]{0,1,2,3}));
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rasch5), null, null, new String[]{"RaschMotivation5"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.slightly), context.getString(R.string.some), context.getString(R.string.a_lot)}, new Integer[]{0,1,2,3}));
        rasch.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rasch6), null, null, new String[]{"RaschMotivation6"}, new String[]{context.getString(R.string.not_at_all), context.getString(R.string.slightly), context.getString(R.string.some), context.getString(R.string.a_lot)}, new Integer[]{0,1,2,3}));
        raschSection = new ItemSection(context.getString(R.string.rasch), rasch);

        ArrayList<ItemQuestion> rand36 = new ArrayList<>();
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.rand36), context.getString(R.string.rand36Description), null, null, null, null));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_1), null, null, new String[]{"Rand36_1"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_2), null, null, new String[]{"Rand36_2"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_3), null, null, new String[]{"Rand36_3"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_4), null, null, new String[]{"Rand36_4"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_5), null, null, new String[]{"Rand36_5"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_6), null, null, new String[]{"Rand36_6"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_7), null, null, new String[]{"Rand36_7"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_8), null, null, new String[]{"Rand36_8"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_9), null, null, new String[]{"Rand36_9"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.rand36_10), null, null, new String[]{"Rand36_10"}, new String[]{context.getString(R.string.limited_a_lot), context.getString(R.string.limited_a_little), context.getString(R.string.not_limited_at_all)}, new Integer[]{1,2,3}));
        rand36Section = new ItemSection(context.getString(R.string.rand36), rand36);

        ArrayList<ItemQuestion> abc = new ArrayList<>();
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE_LONG, context.getString(R.string.abc), context.getString(R.string.abcDescription), null, null, null, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc1), null, new String[]{"ABC1"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc2), null, new String[]{"ABC2"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc3), null, new String[]{"ABC3"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc4), null, new String[]{"ABC4"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc5), null, new String[]{"ABC5"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc6), null, new String[]{"ABC6"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc7), null, new String[]{"ABC7"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc8), null, new String[]{"ABC8"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc9), null, new String[]{"ABC9"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc10), null, new String[]{"ABC10"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc11), null, new String[]{"ABC11"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc12), null, new String[]{"ABC12"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc13), null, new String[]{"ABC13"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc14), null, new String[]{"ABC14"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc15), null, new String[]{"ABC15"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abc.add(new ItemQuestion(ItemQuestion.QuestionType.SLIDER_100_PERCENT, context.getString(R.string.abcTitle), context.getString(R.string.abc16), null, new String[]{"ABC16"}, new String[]{context.getString(R.string.abcOption1), context.getString(R.string.abcOption2)}, null));
        abcSection = new ItemSection(context.getString(R.string.abc), abc);

        ArrayList<ItemQuestion> lsm = new ArrayList<>();
        lsm.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE, context.getString(R.string.lsm), null, null, null, null, null));
        lsm.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_GRID, context.getString(R.string.lsmTitle), context.getString(R.string.lsm1), null, new String[]{"LSM1"}, null, null));
        lsm.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_GRID, context.getString(R.string.lsmTitle), context.getString(R.string.lsm2), null, new String[]{"LSM2"}, null, null));
        lsm.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_GRID, context.getString(R.string.lsmTitle), context.getString(R.string.lsm3), null, new String[]{"LSM3"}, null, null));
        lsm.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_GRID, context.getString(R.string.lsmTitle), context.getString(R.string.lsm4), null, new String[]{"LSM4"}, null, null));
        lsm.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_GRID, context.getString(R.string.lsmTitle), context.getString(R.string.lsm5), null, new String[]{"LSM5"}, null, null));
        lsmSection = new ItemSection(context.getString(R.string.lsm), lsm);

        ArrayList<ItemQuestion> pdq = new ArrayList<>();
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.TITLE_LONG, context.getString(R.string.pdq), context.getString(R.string.pdqDescription), null, null, null, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq1), null, new String[]{"PDQ1"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq2), null, new String[]{"PDQ2"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq3), null, new String[]{"PDQ3"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq4), null, new String[]{"PDQ4"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq5), null, new String[]{"PDQ5"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq6), null, new String[]{"PDQ6"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq7), null, new String[]{"PDQ7"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq8), null, new String[]{"PDQ8"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdq.add(new ItemQuestion(ItemQuestion.QuestionType.BUTTON_FLEXIBLE, context.getString(R.string.pdqTitle), context.getString(R.string.pdq9), null, new String[]{"PDQ9"}, new String[]{context.getString(R.string.never), context.getString(R.string.rarely), context.getString(R.string.sometimes), context.getString(R.string.often), context.getString(R.string.almost_always)}, null));
        pdqSection = new ItemSection(context.getString(R.string.pdq), pdq);


        ArrayList<ItemQuestion> anthropometric = new ArrayList<>();
        anthropometric.add(new ItemQuestion(ItemQuestion.QuestionType.ANTHROPOMETRIC, null, null, null, new String[]{"WEIGHT_kg", "HEIGHT_cm", "BMI_kg_m2", "ARM_CIRC_cm", "CALF_CIRC_cm", "LEG_LENGTH_cm", "SHOE_SIZE"}, null, null));
        anthropometricSection = new ItemSection(context.getString(R.string.anthropometric_measurements), anthropometric);

        ArrayList<ItemQuestion> completion = new ArrayList<>();
        completion.add(new ItemQuestion(ItemQuestion.QuestionType.COMPLETION, null, null, null, null, null, null));
        completionSection = new ItemSection(context.getString(R.string.finish), completion);

        sections = new ArrayList<>();
        sections.add(fallSection);
        sections.add(barthelSection);
        sections.add(oarsSection);
        sections.add(gdsSection);
        sections.add(vahsSection);
        sections.add(moodSection);
        sections.add(appetiteSection);
        sections.add(drivingSection);
        sections.add(walkingSection);
        sections.add(dizzySection);
        sections.add(urineSection);
        sections.add(euroSection);
        sections.add(healthStateSection);
        sections.add(rnlEffortSection);
        sections.add(rnlRestrictionSection);
        sections.add(raschSection);
        sections.add(rand36Section);
        sections.add(abcSection);
        sections.add(lsmSection);
        sections.add(pdqSection);
        sections.add(anthropometricSection);
        sections.add(completionSection);
    }

    public static ArrayList<ItemSection> nurseSections(){

        ArrayList<ItemSection> chosenSections = new ArrayList<>();
        chosenSections.add(fallSection);
        chosenSections.add(barthelSection);
        chosenSections.add(oarsSection);
        chosenSections.add(gdsSection);
        chosenSections.add(vahsSection);
        chosenSections.add(moodSection);
        chosenSections.add(appetiteSection);
        chosenSections.add(drivingSection);
        chosenSections.add(walkingSection);
        chosenSections.add(dizzySection);
        chosenSections.add(urineSection);
        chosenSections.add(completionSection);
        return chosenSections;
    }

    public static ArrayList<ItemSection> evaluatorSections(){

        ArrayList<ItemSection> chosenSections = new ArrayList<>();
        chosenSections.add(euroSection);
        chosenSections.add(healthStateSection);
        chosenSections.add(rnlEffortSection);
        chosenSections.add(rnlRestrictionSection);
        chosenSections.add(raschSection);
        chosenSections.add(rand36Section);
        chosenSections.add(vahsSection);
        chosenSections.add(abcSection);
        chosenSections.add(lsmSection);
        chosenSections.add(pdqSection);
        chosenSections.add(completionSection);
        return chosenSections;
    }

    public static ArrayList<ItemSection> physicalSections(){

        ArrayList<ItemSection> chosenSections = new ArrayList<>();
        chosenSections.add(anthropometricSection);
        chosenSections.add(completionSection);
        return chosenSections;
    }

}
