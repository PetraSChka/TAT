package validator;

import exception.TriangleException;

public class TriangleValidator {
    public boolean checkTrianglePossible(int sideA, int sideB, int sideC) throws TriangleException {
        if (sideA<=0 || sideB<=0 || sideC<=0) {
            throw new TriangleException("Сторона не может быть меньше либо равно нулю");
        }

        if (sideA+sideB<=sideC || sideA+sideC<=sideB || sideB+sideC<=sideA) {
            throw new TriangleException("Такого треугольника не существует");
        }
        return true;
    }
}
