package physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers;

import java.util.ArrayList;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class ItemSection {

    public String title;
    public ArrayList<ItemQuestion> questions;
    public enum Questionnaire{
        NURSE, EVALUATOR, PHYSICAL, SOCIO
    }

    public ItemSection(String title, ArrayList<ItemQuestion> questions){
        this.title = title;
        this.questions = questions;
    }

}
