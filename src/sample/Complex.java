package sample;

public class Complex {
    double re;
    double img;

    public Complex(double re, double img) {
        this.re = re;
        this.img = img;
    }

    public Complex add(Complex c) {
        this.re += c.re;
        this.img += c.img;
        return this;
    }

    public Complex square() {
        Complex c = new Complex(re * re - img * img,2 * re * img);
        this.re = c.re;
        this.img = c.img;
        return this;
    }

    public double module() {
        return Math.sqrt(re * re + img * img);
    }
}
