class Elevator {

    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void moveDown() {
        for (int i = 1; i >= this.minFloor; i--) {
            System.out.println("Elevating ↓ required floor " + i);
            if (this.currentFloor == i) {
                System.out.println("Reached to floor " + this.currentFloor);
                break;
            }
        }
    }

    public void moveUp() {
        for (int i = 1; i <= this.maxFloor; i++) {
            System.out.println("Elevating ↑ the required floor " + i);
            if (this.currentFloor == i) {
                System.out.println("Reached to floor " + this.currentFloor);
                break;
            }
        }
    }


    public void move(int floor) {
        this.currentFloor = floor;
        if (floor >= this.minFloor && (!(floor > 1))) {
            moveDown();
        } else if (floor <= this.maxFloor && (!(floor < 1))) {
            moveUp();
        }
    }
}
