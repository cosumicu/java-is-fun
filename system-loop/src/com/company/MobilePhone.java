package com.company;

public class MobilePhone {
    private float load;
    private char network;

    public float getLoad() {
        return load;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    public char getNetwork() {
        return network;
    }

    public void setNetwork(char network) {
        this.network = network;
    }

    private  final float ratePerText = 1;
    private float getRatePerCall;

    //default constructor
    MobilePhone() {
        this.load = 0;
        this.network = 's';
    }

    MobilePhone (float load, char network) {
        if (load > 0 && (network == 's' || network == 't' || network == 'g')) {
            this.load = load;
            this.network = network;
        }
        else
            System.out.println("Invalid input!!");
    }

    public float checkBalance () {
        return this.load;
    }

    public void call(int minutes, char network) {
        //network = ['s = 3', 't = 5', 'g = 7']
        switch (network) {
            case 's':
                if (this.network != network)
                    this.load -= minutes * 3 * 2;
                else
                this.load -= minutes * 3;
                break;
            case 't':
                if (this.network != network)
                    this.load -= minutes * 5 * 2;
                else
                this.load -= minutes * 5;
                break;
            case 'g':
                if (this.network != network)
                    this.load -= minutes * 7 * 2;
                else
                this.load -= minutes * 7;
                break;
            default:
                System.out.println("Invalid network!!");
        }
    }

    public void text(int length, char network) {
        load -= Math.ceil(length / 160.0);
    }

    public void reload (float amount) {
        this.load += amount;
    }

}
