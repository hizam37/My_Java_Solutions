package gov.myjavaprojects.clientorder.domain;


    public class ClientOrder {
        private String hFirstName;
        private String hLastName;

        private String wFirstName;
        private String wLastName;

        public String gethFirstName() {
            return hFirstName;
        }

        public String gethLastName() {
            return hLastName;
        }

        public String getwFirstName() {
            return wFirstName;
        }

        public String getwLastName() {
            return wLastName;
        }

        public void sethFirstName(String hFirstName) {
            this.hFirstName = hFirstName;
        }

        public void sethLastName(String hLastName) {
            this.hLastName = hLastName;
        }

        public void setwFirstName(String wFirstName) {
            this.wFirstName = wFirstName;
        }

        public void setwLastName(String wLastName) {
            this.wLastName = wLastName;
        }
    }


