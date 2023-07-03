package data.repositories;

import data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DairyRepositoryImp implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<>();
    private int counter = 1;


    @Override
    public Diary save(Diary diary) {
        if (diary.getID() == 0) {
            diaries.add(diary);
            diary.setID(generateID());
        } else diaries.set(generateID() - 1, diary);
        return diary;
    }



    @Override
    public Diary findDiaryById(int id) {
        for(Diary diary : diaries){
            boolean isID = isID(id, diary);
            if (isID)return diary;
        }
        return null;
    }


    @Override
    public List<Diary> findAllDiaries() {
        return diaries;
    }

    @Override
    public void deleteDairyById(int id) {
        for (Diary diary : diaries) {
            boolean isID = isID(id, diary);
            if (isID) {
                diaries.remove(diary);
                break;
            }}}

    @Override
    public void deleteAllDiary(int id) {

    }

    private static boolean isID(int id, Diary diary) {
        boolean isID = diary.getID() == id;
        return isID;
    }


    public int generateID(){
        return diaries.size();
    }



    @Override
    public void deleteDairyByUsername(String username) {
        for(Diary diary : diaries) {
            boolean isUsername = diary.getUsername().equals(username);
            if (isUsername) {
                diaries.remove(diary);
                break;
            }
        }
    }

    @Override
    public int countDiaryNumber() {
        return diaries.size();
    }

    @Override
    public Diary findDiaryByUserName(String userName) {
        for(Diary diary : diaries){
            boolean isUsername = diary.getUsername().equals(userName);
            if (isUsername)return diary;
        }
        return null;
    }
}
