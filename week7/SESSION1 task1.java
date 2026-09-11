class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // slots[1] -> big, slots[2] -> medium, slots[3] -> small
        slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }
}
