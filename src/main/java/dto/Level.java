package dto;

public enum Level {
    BEGINNER {
        @Override
        public String toString() {
            return "beginner";
        }
    },
    MIDDLE {
        @Override
        public String toString() {
            return "middle";
        }
    },
    MASTER {
        @Override
        public String toString() {
            return "master";
        }
    };

    public static Level getLevel(String level) {
        switch (level) {
            case "beginner":
                return BEGINNER;
            case "middle":
                return MIDDLE;
            case "master":
                return MASTER;
            default:
                throw new IllegalArgumentException("This level doesn't exist");
        }
    }


}
