package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HhResumePage {

    private final SelenideElement gender = $("span[data-qa='resume-personal-gender']");
    private final SelenideElement age = $("span[data-qa='resume-personal-age']");
    private final SelenideElement relocate = $("html > body > div:nth-of-type(5) > div > div:nth-of-type(3) > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(1) > div:nth-of-type(3) > p:nth-of-type(1)");
    private final SelenideElement businessTrips = $("html > body > div:nth-of-type(5) > div > div:nth-of-type(3) > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(1) > div:nth-of-type(3) > p:nth-of-type(1)");
    public HhResumePage(String URL){
        Selenide.open(URL);
    }

    public String getGender(){
        return gender.getText().equals("Male")? "M" : "F";
    }

    public int getAge(){
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    //with contains
    public boolean isReadyToRelocate(){
        String subString = "I want to relocate";
        return relocate.toString().contains(subString);
    }

    //with splitting an array of String
    public boolean isReadyForBusinessTrips(){
        String[] data = businessTrips.getText().split(", ");
        return data[data.length - 1].equals("prepared for business trips");
    }




}
