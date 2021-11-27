class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if(!firstName.equals(null) && !firstName.equals("")){
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if(!lastName.equals(null) &&  !lastName.equals("")){
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if ((firstName.equals(null) || firstName.equals("")) && (lastName.equals(null) || lastName.equals(""))) {
            return "Unknown";
        }

        if (!firstName.equals(null) && !lastName.equals(null)) {
            return this.firstName + " " + lastName;
        } else if (firstName.equals(null)) {
            return lastName;
        } else if (lastName.equals(null)) {
            return firstName;
        }else{
            return "Unknown";
        }

        // write your code here
    }
}