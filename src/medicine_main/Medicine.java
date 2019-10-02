
package medicine_main;

public class Medicine {
    String MedDiscription;
    String GenericName;
    String BrandName;
    double Medprice;
    String illness;

    public Medicine( String MedDiscription,String GenericName, String BrandName, double Medprice, String illness) {
        this.GenericName = GenericName;
        this.BrandName = BrandName;
        this.MedDiscription = MedDiscription;
        this.Medprice = Medprice;
        this.illness = illness;
    }

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String GenericName) {
        this.GenericName = GenericName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getMedDiscription() {
        return MedDiscription;
    }

    public void setMedDiscription(String MedDiscription) {
        this.MedDiscription = MedDiscription;
    }

    public double getMedprice() {
        return Medprice;
    }

    public void setMedprice(double Medprice) {
        this.Medprice = Medprice;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return String.format("%30s %5s %20s %5s %20s %5s %15s %5s", MedDiscription,"|", GenericName,"|", BrandName,"|",Medprice, "\n");
        
    }
}
