package entity;

public class Flor {

    private double larguraSepala;
    private double alturaSepala;
    private double larguraPetala;
    private double alturaPetala;

    public Flor() {
    }

    public Flor(double larguraSepala, double alturaSepala, double larguraPetala, double alturaPetala) {
        this.larguraSepala = larguraSepala;
        this.alturaSepala = alturaSepala;
        this.larguraPetala = larguraPetala;
        this.alturaPetala = alturaPetala;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "larguraSepala=" + larguraSepala +
                ", alturaSepala=" + alturaSepala +
                ", arguraPetala=" + larguraPetala +
                ", alturaPetala=" + alturaPetala +
                '}';
    }

    public double getLarguraSepala() {
        return larguraSepala;
    }

    public void setLarguraSepala(double larguraSepala) {
        this.larguraSepala = larguraSepala;
    }

    public double getAlturaSepala() {
        return alturaSepala;
    }

    public void setAlturaSepala(double alturaSepala) {
        this.alturaSepala = alturaSepala;
    }

    public double getLarguraPetala() {
        return larguraPetala;
    }

    public void setLarguraPetala(double larguraPetala) {
        this.larguraPetala = larguraPetala;
    }

    public double getAlturaPetala() {
        return alturaPetala;
    }

    public void setAlturaPetala(double alturaPetala) {
        this.alturaPetala = alturaPetala;
    }
}
