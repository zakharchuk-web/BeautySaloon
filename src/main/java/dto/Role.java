package dto;

public enum Role {
    USER {
        @Override
        public String toString() {
            return "user";
        }

    },
    ADMIN {
        @Override
        public String toString() {
            return "admin";
        }

    },
    MASTER {
        @Override
        public String toString() {
            return "master";
        }

    };

    public static Role getRole(Long role) {
        switch (role.intValue()) {
            case 1:
                return USER;
            case 2:
                return ADMIN;
            case 3:
                return MASTER;
            default:
                System.out.println(role);
                throw new IllegalArgumentException("This role doesn't exist");
        }
    }
}
