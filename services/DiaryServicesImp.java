package services;

import data.model.Entry;
import dto.ChangeDiaryPasswordRequest;
import data.model.Diary;
import data.repositories.DairyRepositoryImp;
import data.repositories.DiaryRepository;
import dto.RegisterDiaryRequestDto;
import dto.UnlockDiaryRequestDto;

public class DiaryServicesImp implements DiaryServices{


    private DiaryRepository diaryRepository = new DairyRepositoryImp();
    private EntryServiceImpl entryService = new EntryServiceImpl();


    @Override
    public void registerDiary(RegisterDiaryRequestDto requestDto) {
        validateDuplicateUsername(requestDto.getUsername());
        Diary diary = new Diary();
        diary.setUsername(requestDto.getUsername());
        diary.setPassword(requestDto.getPassword());
        diaryRepository.save(diary);
    }


    //@Override
    public void unlockDiary(UnlockDiaryRequestDto unlockDiaryRequestDto) {
        validateUsername(unlockDiaryRequestDto.getUsername());
        Diary foundDairy = validateUsername(unlockDiaryRequestDto.getUsername());
        boolean isPasswordCorrect = foundDairy.getPassword().equals(unlockDiaryRequestDto.getPassword());
        if(isPasswordCorrect)foundDairy.setLogging(true);
    }

    @Override
    public  int count(){
        return diaryRepository.countDiaryNumber();
    }


    @Override
    public void changeDiaryPassword(ChangeDiaryPasswordRequest request) {
          Diary foundDiary = validateUsername(request.getUsername());
        validatePassword(request.getUsername(), request.getOldPassword());
            foundDiary.setPassword(request.getNewPassword());
            diaryRepository.save(foundDiary);
    }

    @Override
    public void createDiaryEntry(int diaryId, String title, String body) {
        validateDiaryID(diaryId);
        Diary foundDairy = diaryRepository.findDiaryById(diaryId);
        int diaryID = foundDairy.getID();
        entryService.createEntry(diaryID, title, body);

    }

    @Override
    public void deleteDiaryEntry(int diaryId, String title) {

    }

    @Override
    public Entry searchDiaryEntryByTitle(int diaryId, String title) {
        return null;
    }

    @Override
    public void updateDiaryEntry(int diaryId, String title, String body) {

    }

    @Override
    public Entry findDiaryEntryById(int diaryId) {
        return null;
    }


    @Override
    public boolean isogging(String username) {
           Diary foundDiary = validateUsername(username);
        return  foundDiary.isLogging();
    }


    private void validateDiaryID(int diaryId) {
        Diary foundDiary = diaryRepository.findDiaryById(diaryId);
        if (foundDiary == null) throw new IllegalArgumentException("Diary ID not match try again!!");
    }



    private void validateDuplicateUsername(String username){
        Diary foundDiary = diaryRepository.findDiaryByUserName(username);
        boolean isFoundDiaryNull = foundDiary == null;
        if(isFoundDiaryNull) {
            return;
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
