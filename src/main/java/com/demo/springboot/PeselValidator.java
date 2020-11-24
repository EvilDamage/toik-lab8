package com.demo.springboot;

public class PeselValidator {
    private byte PESEL[] = new byte[11];
    private boolean valid = false;

    public PeselValidator(String PESELNumber) {
        if (PESELNumber.length() != 11){
            valid = false;
        }
        else {
            for (int i = 0; i < 11; i++){
                PESEL[i] = Byte.parseByte(PESELNumber.substring(i, i+1));
            }
            if (checkSum()) {
                valid = true;
            }
            else {
                valid = false;
            }
        }
    }

    public boolean isValid() {
        return valid;
    }

    private boolean checkSum() {
        int sum = 1 * PESEL[0] +
                3 * PESEL[1] +
                7 * PESEL[2] +
                9 * PESEL[3] +
                1 * PESEL[4] +
                3 * PESEL[5] +
                7 * PESEL[6] +
                9 * PESEL[7] +
                1 * PESEL[8] +
                3 * PESEL[9];
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        if (sum == PESEL[10]) {
            return true;
        }
        else {
            return false;
        }
    }
}
