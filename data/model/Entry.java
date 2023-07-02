package data.model;

    public class Entry {

        private int diaryID;
        private String title;
        private String body;
        private int id;


        public int getDiaryID() {
            return diaryID;
        }

        public void setDiaryID(int diaryID) {
            this.diaryID = diaryID;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("""
                                 Title %s,
                                 Body %s""", title, body); }
    }


