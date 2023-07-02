package data.repositories;

import data.model.Entry;

import java.util.List;

public interface EntryRepository {

    void save(Entry entry);
    Entry findEntryById(int id);
    List<Entry> findEntriesByDiaryId(String diaryId);
    List<Entry> findAllEntries();
    void deleteEntryByTitle(String title);
    void deleteEntryById(int id);
    void updateEntry(int id, String title, String body);
    int countNumberOfEntry();
    Entry findEntryByTitle(String title);




}
