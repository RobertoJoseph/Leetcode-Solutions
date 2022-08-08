class ParkingSystem {
    
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big =big;
        this.small = small;
        this.medium = medium;
    }
    
    public boolean addCar(int carType) {
        //Checking for big
        if(carType==1)
            if(this.big>=1){
                big--;
                return true;
            }
        if(carType==2)if(this.medium>=1){
            medium--;
            return true;}
        
        if(carType==3)if(this.small>=1){
            small--;
            return true;
        }
        return false;
            
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */