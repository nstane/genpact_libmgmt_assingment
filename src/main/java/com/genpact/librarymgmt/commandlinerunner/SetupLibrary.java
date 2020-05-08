package com.genpact.librarymgmt.commandlinerunner;

import com.genpact.librarymgmt.dto.Library;
import com.genpact.librarymgmt.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SetupLibrary implements CommandLineRunner {
    @Autowired
    private LibraryRepository libraryRepository;
    @Override
    public void run(String... args) throws Exception {
        // Create a library Object in DB
        List<Library> libraries = libraryRepository.findAll();
        if(libraries.isEmpty()) {
            libraryRepository.save(new Library("Genpact Book Library"));
        }
    }
}
