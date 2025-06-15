import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Pet
{
    String name;
    String breed;
    int age;
    String feedSchedule;
    String groomingSchedule;
    String bathSchedule;
    String nailCuttingSchedule;
    String trainingSchedule;
    String exerciseSchedule;
    String vaccineSchedule;
    String medicalCheckupSchedule;

    public Pet(String name, String breed, int age)
    {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
}

class PetCareManagementSystem
{
    private Scanner scanner = new Scanner(System.in);
    private Pet[] pets = new Pet[5];  // Max 5 pets for simplicity
    private int petCount = 0;

    private User[] users = new User[5]; // Max 5 users
    private int userCount = 0;

    private User loggedInUser = null;

    public void run()
    {
        System.out.println("*********************************************************************************************************************************************************");
        System.out.println("                                               Welcome to the Pet Care Management System                                                                 ");
        System.out.println("*********************************************************************************************************************************************************");
        while (true)
        {
            if (loggedInUser == null)
            {
                showAuthMenu();
            }
            else
            {
                showMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice)
                {
                    case 1:
                        addPetProfile();
                        break;
                    case 2:
                        viewAllPets();
                        break;
                    case 3:
                        updatePetProfile();
                        break;
                    case 4:
                        deletePet();
                        break;
                    case 5:
                        adoptionProcess();
                        break;
                    case 6:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private void showAuthMenu() {
        System.out.println("\n-------------------------------------------------- Authentication Menu ---------------------------------------------------------------------------------");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch(choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                System.out.println("Exiting system...");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Register user
    private void registerUser() {
        if(userCount >= users.length) {
            System.out.println("User limit reached. Cannot register more users.");
            return;
        }
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();

        // Check if username already exists
        for(int i=0; i<userCount; i++) {
            if(users[i].username.equals(username)) {
                System.out.println("Username already exists. Try another.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users[userCount++] = new User(username, password);
        System.out.println("Registration successful. You can now login.");
    }

    // Login user
    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for(int i=0; i<userCount; i++) {
            if(users[i].username.equals(username) && users[i].password.equals(password)) {
                loggedInUser = users[i];
                System.out.println("Login successful. Welcome, " + loggedInUser.username + "!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    // Logout
    private void logout() {
        System.out.println("Logging out " + loggedInUser.username + "...");
        loggedInUser = null;
    }

    // Show main menu
    private void showMainMenu()
    {
        System.out.println("\n-------------------------------------------------------------- Main Menu ---------------------------------------------------------------------------");
        System.out.println("1. Add Pet Profile");
        System.out.println("2. View All Pets");
        System.out.println("3. Update Pet Profile");
        System.out.println("4. Delete Pet Profile");
        System.out.println("5. Adoption Process");
        System.out.println("6. Logout");
        System.out.print("Enter your choice: ");
    }

    // Add pet profile
    private void addPetProfile()
    {
        if (petCount >= pets.length)
        {
            System.out.println("Pet limit reached. Cannot add more pets.");
            return;
        }

        System.out.println("\n=============================================================== Enter Pet Details ==================================================================");
        System.out.print("Pet Name: ");
        String name = scanner.nextLine();

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Pet pet = new Pet(name, breed, age);

        // Feed schedule
        System.out.print("Feed Schedule: ");
        pet.feedSchedule = scanner.nextLine();

        // Grooming schedule
        System.out.print("Grooming Schedule: ");
        pet.groomingSchedule = scanner.nextLine();

        // Bathing schedule
        System.out.print("Bath Schedule: ");
        pet.bathSchedule = scanner.nextLine();

        // Nail cutting schedule
        System.out.print("Nail Cutting Schedule: ");
        pet.nailCuttingSchedule = scanner.nextLine();

        // Training schedule
        System.out.print("Training Schedule: ");
        pet.trainingSchedule = scanner.nextLine();

        // Exercise schedule
        System.out.print("Exercise Schedule: ");
        pet.exerciseSchedule = scanner.nextLine();

        // Vaccine schedule
        System.out.print("Vaccine Schedule: ");
        pet.vaccineSchedule = scanner.nextLine();

        // Medical check-up schedule
        System.out.print("Medical Check-up Schedule: ");
        pet.medicalCheckupSchedule = scanner.nextLine();

        pets[petCount++] = pet;  // Add the pet and increment pet count
        System.out.println("Pet profile added successfully.");
    }

    // View all pets
    private void viewAllPets()
    {
        if (petCount == 0)
        {
            System.out.println("No pets found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------- Pet Profiles ----------------------------------------------------------------------------");
        for (int i = 0; i < petCount; i++)
        {
            Pet pet = pets[i];
            System.out.println("\nPet " + (i + 1) + ": ");
            System.out.println("Name: " + pet.name);
            System.out.println("Breed: " + pet.breed);
            System.out.println("Age: " + pet.age);
            System.out.println("Feed Schedule: " + pet.feedSchedule);
            System.out.println("Grooming Schedule: " + pet.groomingSchedule);
            System.out.println("Bath Schedule: " + pet.bathSchedule);
            System.out.println("Nail Cutting Schedule: " + pet.nailCuttingSchedule);
            System.out.println("Training Schedule: " + pet.trainingSchedule);
            System.out.println("Exercise Schedule: " + pet.exerciseSchedule);
            System.out.println("Vaccine Schedule: " + pet.vaccineSchedule);
            System.out.println("Medical Check-up Schedule: " + pet.medicalCheckupSchedule);
        }
    }

    // Update pet profile
    private void updatePetProfile()
    {
        if (petCount == 0)
        {
            System.out.println("No pets found.");
            return;
        }

        System.out.print("Enter Pet Name to update: ");
        String petName = scanner.nextLine();
        Pet petToUpdate = null;

        for (int i = 0; i < petCount; i++)
        {
            if (pets[i].name.equalsIgnoreCase(petName))
            {
                petToUpdate = pets[i];
                break;
            }
        }

        if (petToUpdate != null)
        {
            System.out.println("Updating profile for " + petToUpdate.name);

            // Update details
            System.out.print("New Feed Schedule: ");
            petToUpdate.feedSchedule = scanner.nextLine();

            System.out.print("New Grooming Schedule: ");
            petToUpdate.groomingSchedule = scanner.nextLine();

            System.out.print("New Bath Schedule: ");
            petToUpdate.bathSchedule = scanner.nextLine();

            System.out.print("New Nail Cutting Schedule: ");
            petToUpdate.nailCuttingSchedule = scanner.nextLine();

            System.out.print("New Training Schedule: ");
            petToUpdate.trainingSchedule = scanner.nextLine();

            System.out.print("New Exercise Schedule: ");
            petToUpdate.exerciseSchedule = scanner.nextLine();

            System.out.print("New Vaccine Schedule: ");
            petToUpdate.vaccineSchedule = scanner.nextLine();

            System.out.print("New Medical Check-up Schedule: ");
            petToUpdate.medicalCheckupSchedule = scanner.nextLine();

            System.out.println("Pet profile updated successfully.");
        }
        else
        {
            System.out.println("Pet not found.");
        }
    }

    // Delete pet profile
    private void deletePet()
    {
        if (petCount == 0)
        {
            System.out.println("No pets found.");
            return;
        }

        System.out.print("Enter Pet Name to delete: ");
        String petName = scanner.nextLine();
        Pet petToDelete = null;
        int deleteIndex = -1;

        for (int i = 0; i < petCount; i++)
        {
            if (pets[i].name.equalsIgnoreCase(petName))
            {
                petToDelete = pets[i];
                deleteIndex = i;
                break;
            }
        }

        if (petToDelete != null)
        {
            // Shift pets in the array to remove the deleted pet
            for (int i = deleteIndex; i < petCount - 1; i++)
            {
                pets[i] = pets[i + 1];
            }
            pets[petCount - 1] = null;  // Set the last position to null
            petCount--;  // Decrease pet count
            System.out.println("Pet profile deleted successfully.");
        }
        else
        {
            System.out.println("Pet not found.");
        }
    }

    // Adoption process
    private void adoptionProcess()
    {
        System.out.println("\nAdoption Process:");
        System.out.println("1. Fill Adoption Form");
        System.out.println("2. Responsibility after adoption");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice)
        {
            case 1:
                fillAdoptionForm();
                break;
            case 2:
                System.out.println("\nResponsibilities after adoption:");
                System.out.println("- Provide proper care and attention.");
                System.out.println("- Regular vet visits.");
                System.out.println("- Proper feeding, grooming, and exercise.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Adoption form details
    private void fillAdoptionForm()
    {
        System.out.println("\n==== Adoption Form ====");

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        // Generate email by removing spaces and converting to lowercase
        String email = fullName.toLowerCase().replaceAll("\\s+", "") + "@gmail.com";
        System.out.println("Generated Email: " + email);

        String contactNo;
        while(true)
        {
            System.out.print("Contact Number (10 digits): ");
            contactNo = scanner.nextLine();

            // Validate contact number (only digits and exactly 10 digits)
            if (contactNo.matches("\\d{10}"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid contact number. Please enter exactly 10 digits.");
            }
        }

        System.out.print("Pet you want to adopt (Name): ");
        String petName = scanner.nextLine();

        // Check if pet exists
        Pet petToAdopt = null;
        for (int i = 0; i < petCount; i++)
        {
            if (pets[i].name.equalsIgnoreCase(petName))
            {
                petToAdopt = pets[i];
                break;
            }
        }

        if (petToAdopt == null)
        {
            System.out.println("Sorry, the pet '" + petName + "' is not available for adoption.");
            return;
        }

        System.out.println("\nAdoption form submitted successfully!");
        System.out.println("Details:");
        System.out.println("Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Contact Number: " + contactNo);
        System.out.println("Adopting Pet: " + petToAdopt.name + " (" + petToAdopt.breed + ")");
    }
}

public class PCM
{
    public static void main(String[] args)
    {
        // Create an instance of the PetCareManagementSystem class
        PetCareManagementSystem system = new PetCareManagementSystem();

        // Start the system
        system.run();
    }
}
