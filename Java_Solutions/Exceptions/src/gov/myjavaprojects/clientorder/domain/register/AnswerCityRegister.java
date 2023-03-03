package gov.myjavaprojects.clientorder.domain.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
    private List<AnswerCityRegisterItem> items;

    public List<AnswerCityRegisterItem> getItems() {
        return items;
    }


    public void addItem(AnswerCityRegisterItem item)
    {
        if(items==null)
        {
            items = new ArrayList<>(10);
        }
        items.add(item);
    }
}
