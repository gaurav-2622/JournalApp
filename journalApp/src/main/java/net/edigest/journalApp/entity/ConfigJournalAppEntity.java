package net.edigest.journalApp.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "config_journal_app")
@Data
public class ConfigJournalAppEntity {

    private String key;
    private String value;
}
