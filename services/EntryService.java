package services;

import data.model.Entry;

public interface EntryService {

    void createEntry(int diaryId, String title, String body);
    Entry findByTitle(int diaryID,String title);
    void updateEntry(int diaryID, String title, String body);
    void deleteEntry(int diaryId, String title);
    void deleteAllEntry(int  diaryId);
    int count();
}
