package data.repositories;

import data.model.Diary;

import java.util.List;

public interface DiaryRepository {


    Diary save(Diary diary);
    Diary findDiaryById(int id);
    List<Diary> findAllDiaries();
    void deleteDairyById(int id);
    void deleteAllDiary(int id);
    void deleteDiaryByUsername(String username);
    int countDiaryNumber();
    Diary findDiaryByUserName(String userName);

}
