package services;

import data.model.Entry;
import data.repositories.EntryRepositoriesImp;
import data.repositories.EntryRepository;

public class EntryServiceImpl implements EntryService{
    private EntryRepository entryRepository = new EntryRepositoriesImp();
    @Override
    public void save(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public void deleteEntry(int diaryId, String title) {
        entryRepository.deleteEntry(diaryId, title);
    }
}
