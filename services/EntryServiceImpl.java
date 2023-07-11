package services;

import data.model.Entry;
import data.repositories.EntryRepositoriesImp;
import data.repositories.EntryRepository;

public class EntryServiceImpl implements EntryService{
    private EntryRepository entryRepository = new EntryRepositoriesImp();
//    @Override
//    public void save(Entry entry) {
//        entryRepository.save(entry);
//    }

    @Override
    public void createEntry(int diaryId, String title, String body) {
        Entry entry = new Entry();
        entry.setTitle(title);
        entry.setBody(body);
        entry.setDiaryID(diaryId);
        entryRepository.save(entry);
    }

    @Override
    public Entry findByTitle(int diaryID, String title) {
        validateTitle(title);
       Entry foundEntry = entryRepository.findEntryByTitle(diaryID, title);
       return foundEntry;
    }

    @Override
    public void updateEntry(int diaryID, String title, String body) {
        validateTitle(title);
        Entry foundEntry = findByTitle(diaryID, title);
        foundEntry.setBody(body);
    }

    @Override
    public void deleteEntry(int diaryId, String title) {
        validateTitle(title);
        entryRepository.deleteEntry(diaryId, title);
    }

    @Override
    public void deleteAllEntry(int diaryId) {

    }

    @Override
    public int count() {
        return entryRepository.countNumberOfEntry();
    }
    private void validateTitle(String title){
       Entry foundEntry = entryRepository.findEntryByTitle(title);
        boolean isFoundDiaryNull = foundEntry != null;
        if (isFoundDiaryNull)return;
       else throw new IllegalArgumentException("title not found in the diary");
   }

}
