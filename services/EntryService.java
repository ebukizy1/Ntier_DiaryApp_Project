package services;

import data.model.Entry;

public interface EntryService {
    void save(Entry entry);

    void deleteEntry(int diaryId, String title);
}
