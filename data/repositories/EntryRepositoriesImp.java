package data.repositories;

import data.model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoriesImp implements EntryRepository {
        private List<Entry> entries = new ArrayList<>();

    @Override
    public void save(Entry entry) {
        if(entry.getId() == 0) {
            entries.add(entry);
            entry.setId(generateID());
        }
        else entries.set(entry.getId()-1, entry);

    }

    @Override
    public Entry findEntryById(int id) {
        for(Entry entry : entries){
            boolean isID = isID(id, entry);
            if (isID)return entry;
        }
        return null;
    }
    public int generateID(){
        return entries.size();
    }

    private static boolean isID(int id, Entry entry) {
        boolean isID = entry.getId() == id;
        return isID;
    }

    @Override
    public List<Entry> findEntriesByDiaryId(String diaryId) {
        return null;
    }

    @Override
    public List<Entry> findAllEntries() {
        return null;
    }

    @Override
    public void deleteEntryByTitle(String title) {
            for (Entry entry : entries) {
                if (entry.getTitle().equals(title)) {
                   entries.remove(entry);
                    break;
                }

            }
    }

    @Override
    public void deleteEntryById(int id) {

    }

    @Override
    public void updateEntry(int id, String title, String body) {


    }
    public Entry findEntryByTitle(String title) {
        for(Entry entry : entries) {
            boolean isTitle = entry.getTitle().equals(title);
            if(isTitle)return entry;
        }
        return null;
    }

    @Override
    public int countNumberOfEntry() {
        return entries.size();
    }

    @Override
    public Entry findEntryByTitle(int diaryID, String title) {
        for(Entry entry : entries) {
            boolean isTitle = entry.getTitle().equals(title) && entry.getDiaryID() == diaryID;
            if(isTitle)return entry;
        }
        return null;
    }

    @Override
    public void deleteEntry(int diaryId, String title) {
        for(Entry entry : entries){
            boolean isCorrectEntry = entry.getTitle().equals(title) && entry.getDiaryID() == diaryId;
            if(isCorrectEntry) {
                entries.remove(entry);
                break;
            }
        }
    }
}
