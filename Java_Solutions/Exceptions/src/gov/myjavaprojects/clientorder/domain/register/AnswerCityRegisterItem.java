package gov.myjavaprojects.clientorder.domain.register;

import gov.myjavaprojects.clientorder.domain.Person;

public class AnswerCityRegisterItem {
    public enum CityStatus {
        YES,NO,ERROR;
    }

    public static class CityError {

        private String code;
        private String text;

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }

        public CityError(String Code, String Text) {
            this.code = Code;
            this.text = Text;
        }

    }
    private CityStatus status;
    private Person person;
    private CityError error;

    public AnswerCityRegisterItem(CityStatus status, Person person, CityError error) {
        this.status = status;
        this.person = person;
        this.error = error;
    }

    public AnswerCityRegisterItem(CityStatus status, Person person) {
        this.status = status;
        this.person = person;
    }

    public CityStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public CityError getError() {
        return error;
    }
}
