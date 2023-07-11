package data.model;


    public class Diary {
        private  String username;
        private String password;
        private boolean isLogging ;
        private int ID;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }



        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isLogging() {
            return isLogging;
        }

        public void setLogging(boolean logging) {
            isLogging = logging;
        }
    }


