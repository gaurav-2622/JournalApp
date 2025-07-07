package net.edigest.journalApp.service;

import net.edigest.journalApp.entity.JournalEntry;
import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName)
    {  try {
        User user = userService.findByuserName(userName);
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);
    }catch (Exception e){
        System.out.println(e);
        throw new RuntimeException("An eeror has occured while saving the entry",e);
    }

    }


    public void saveEntry(JournalEntry journalEntry)
    {   journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId myId){
        return journalEntryRepository.findById(myId);
    }
    @Transactional
    public boolean deleteById(ObjectId myId, String userName){
        boolean removed = false;
        try {
            User user = userService.findByuserName(userName);
             removed = user.getJournalEntries().removeIf(x -> x.getId().equals(myId));
            if (removed){
                userService.saveUser(user);
                journalEntryRepository.deleteById(myId);
            }
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry" , e);
        }
         return removed;
    }
}
