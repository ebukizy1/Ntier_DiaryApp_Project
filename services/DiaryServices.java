package services;

import data.model.Entry;

public interface DiaryServices {

        void registerDiary(String username, String password);
        void unlockDiary(String username, String password);
        void changeDiaryPassword(String username, String oldPassword, String newPassword);
        void createDiaryEntry(int diaryId, String title, String body);
        void deleteDiaryEntry(int diaryId, String title);
        Entry searchDiaryEntryByTitle(int diaryId , String title);
        void updateDiaryEntry(int diaryId, String title, String body);
        Entry findDiaryEntryById(int diaryId);
        int count();
        boolean isLock(String username);
}

