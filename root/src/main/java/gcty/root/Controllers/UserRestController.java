package gcty.root.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gcty.root.Entities.Keikka;
import gcty.root.Entities.User;
import gcty.root.Repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping // GET: hae kaikki käyttäjät
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}") //GET: hae käyttäjä ID:n perusteella
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user
                .map(ResponseEntity::ok)
                .orElseGet (()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping // POST: Lisää uusi käyttäjä
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{id}") // PUT: Päivitä olemassa oleva käyttäjä
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            
            existingUser.setUserName(userDetails.getUserName());
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPhone(userDetails.getPhone());
            existingUser.setPassword(userDetails.getPasswordHash());

            existingUser.setUserRole(userDetails.getUserRoleName()); // MUUTA ETTÄ VAIN ADMIN-ROOLIN OMAAVA VOI MUUTTAA

            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } 
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}") // DELETE: poista käyttäjä ID:n perusteella 
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // KÄYTTÄJÄN LUONTI:

    @GetMapping("/create")
    public String showFrom(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/create")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user-form";
        }
        else {
            return "redirect:/api/index";
        }
    }

}
