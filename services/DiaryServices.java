package services;

import data.model.Entry;
import dto.ChangeDiaryPasswordRequest;
import dto.RegisterDiaryRequestDto;
import dto.UnlockDiaryRequestDto;

public interface DiaryServices {

        void registerDiary(RegisterDiaryRequestDto requestDto);
        void unlockDiary(UnlockDiaryRequestDto unlockDiaryRequestDto);
        void changeDiaryPassword(ChangeDiaryPasswordRequest requestDto);
        void createDiaryEntry(int diaryId, String title, String body);
        void deleteDiaryEntry(int diaryId, String title);
        Entry searchDiaryEntryByTitle(int diaryId , String title);
        void updateDiaryEntry(int diaryId, String title, String body);
        Entry findDiaryEntryById(int diaryId);
        int count();
        boolean isogging(String username);
}

