package services;

import data.model.Diary;
import data.model.Entry;
import data.repositories.DairyRepositoryImp;
import data.repositories.DiaryRepository;
import data.repositories.EntryRepositoriesImp;
import data.repositories.EntryRepository;

public class DiaryServicesImp implements DiaryServices{
        private int count;
    private DiaryRepository diaryRepository = new DairyRepositoryImp();
    private EntryRepository entryRepository = new EntryRepositoriesImp();


    @Override
    public void registerDiary(String username, String password) {
        validateDuplicateUsername(username);
        Diary diary = DiaryCreated(username, password);
        entryCreated(diary);
        count++;
    }




    @Override
    public void unlockDiary(String username, String password) {
        Diary foundDairy = validateUsername(username);
       String validPassword = validatePassword(username, password);
        boolean isPasswordCorrect = foundDairy.getPassword().equals(validPassword);
        if(isPasswordCorrect)foundDairy.setLocked(false);
    }



    @Override
    public void changeDiaryPassword(String username, String oldPassword, String newPassword) {
          Diary foundDiary = validateUsername(username);
        String validPassword = validatePassword(username, oldPassword);
            foundDiary.setPassword(newPassword);
    }


    @Override
    public void createDiaryEntry(int diaryId, String title, String body) {
        Entry foundEntry = validateDiaryID(diaryId);
        foundEntry.setTitle(title);
        foundEntry.setBody(body);
    }

    @Override
    public void deleteDiaryEntry(int diaryId, String title) {
        Entry foundEntry = validateDiaryID(diaryId);
        entryRepository.deleteEntryByTitle(title);
    }

    @Override
    public Entry searchDiaryEntryByTitle(int diaryId, String title) {
        validateTitle(title);
        Entry foundEntry = validateDiaryID(diaryId);
        Entry foundEntryCreated = entryRepository.findEntryByTitle(title);
        return  foundEntryCreated;
    }

    @Override
    public void updateDiaryEntry(int diaryId, String title, String body) {

    }

    @Override
    public Entry findDiaryEntryById(int diaryId) {
        Entry foundEntry = validateDiaryID(diaryId);
        return foundEntry;
    }


    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean isLock(String username) {
           Diary foundDiary = validateUsername(username);
        return  foundDiary.isLocked();
    }



    private Diary DiaryCreated(String username, String password) {
        Diary diary = new Diary();
        diary.setUsername(username);
        diary.setPassword(password);
        diaryRepository.save(diary);
        return diary;
    }
    private void validateTitle(String title){
       Entry foundEntry = entryRepository.findEntryByTitle(title);
        boolean isFoundDiaryNull = foundEntry != null;
        if (isFoundDiaryNull)return;
        else throw new IllegalArgumentException("title not found in the diary");
    }

    private Entry validateDiaryID(int diaryId) {
        Entry foundEntry = entryRepository.findEntryById(diaryId);
        if (foundEntry != null) return foundEntry;
        else throw new IllegalArgumentException("Diary ID not match try again!!");
    }

    private void entryCreated(Diary diary) {
        Entry entry = new Entry();
        entry.setBody("welcome to your diary!!!!!!");
        entry.setDiaryID(diary.getID());
        entryRepository.save(entry);
    }


    private void validateDuplicateUsername(String username){
        Diary foundDiary = diaryRepository.findDiaryByUserName(username);
        boolean isFoundDiaryNull = foundDiary == null;
        if(isFoundDiaryNull) {
        }
        else throw new IllegalArgumentException("username already exist try " + username + "4u" );
    }


    private Diary validateUsername(String username){
        Diary foundDiary = diaryRepository.findDiaryByUserName(username);
        boolean isFoundDiaryNull = foundDiary != null;
            if(isFoundDiaryNull)return foundDiary;
            else throw new IllegalArgumentException("username name does not exist try again");
    }


    private String validatePassword(String username, String password){
        Diary foundDiary =  validateUsername(username);
        boolean isPasswordCorrect = foundDiary.getPassword().equals(password);
        if(isPasswordCorrect)return password;
        throw new IllegalArgumentException("incorrect password enter !!");
    }


}
