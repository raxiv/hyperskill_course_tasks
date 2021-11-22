

class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        robot.stepForward();
        // your implementation here




Airection.NORTH.toString();




        System.out.println("weszlo");
        if (robot.getX() < toX) {
            switch (robot.getDirection()) {
                case UP:
                    robot.turnRight();
                    break;
                case RIGHT:
                    break;
                case LEFT:
                    robot.turnRight();
                    robot.turnRight();
                    break;
                case DOWN:
                    robot.turnLeft();
                    break;
            }
            while (robot.getX() < toX) {
                robot.stepForward();
            }
        } else {
            if (robot.getX() > toX) {
                switch (robot.getDirection()) {
                    case UP:
                        robot.turnLeft();
                        break;
                    case RIGHT:
                        robot.turnLeft();
                        robot.turnLeft();
                        break;
                    case LEFT:
                        break;
                    case DOWN:
                        robot.turnRight();
                        break;
                }
                while (robot.getX() > toX) {
                    robot.stepForward();
                }
            }
        }


        if (robot.getY() < toY) {
            switch (robot.getDirection()) {
                case UP:
                    break;
                case RIGHT:
                    robot.turnLeft();
                    break;
                case LEFT:
                    robot.turnRight();
                    break;
                case DOWN:
                    robot.turnRight();
                    robot.turnRight();
                    break;
            }
            while (robot.getY() < toY) {
                robot.stepForward();

            }
        } else {
            if (robot.getY() > toY) {
                switch (robot.getDirection()) {
                    case UP:
                        robot.turnRight();
                        robot.turnRight();
                        break;
                    case RIGHT:
                        robot.turnRight();
                        break;
                    case LEFT:
                        robot.turnLeft();
                        break;
                    case DOWN:
                        break;
                }
                while (robot.getY() > toY) {
                    robot.stepForward();
                }
            }
        }


    }

}


enum Airection {
    EAST("E"),
    WEST("W"),
    NORTH("N"),
    SOUTH("S");

    private final String shortCode;

    Airection(String code) {
        this.shortCode = code;
    }

    public String getShortCode() {
        return this.shortCode;
    }

}
//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}