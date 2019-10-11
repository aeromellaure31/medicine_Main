
package medicine_main;

public class Medicine {
    private String medName;
    private String genericName;
    private String brandName;
    private double medPrice;
    private String illness;
    private int quantity;

    public Medicine( String MedDiscription,String GenericName, String BrandName, double Medprice, String illness) {
        this.genericName = GenericName;
        this.brandName = BrandName;
        this.medName = MedDiscription;
        this.medPrice = Medprice;
        this.illness = illness;
    } 

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public double getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(double medPrice) {
        this.medPrice = medPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String GenericName) {
        this.genericName = GenericName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String BrandName) {
        this.brandName = BrandName;
    }
    
    public double getMedprice() {
        return medPrice;
    }

    public void setMedprice(double Medprice) {
        this.medPrice = Medprice;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
    
    public String order(){
        return String.format("%30s %5s %20s %5s %20s %5s %15s %5s", medName,"|", genericName,"|", brandName,"|",quantity, "\n");
    }

    @Override
    public String toString() {
        return String.format("%30s %5s %20s %5s %20s %5s %15s %5s", medName,"|", genericName,"|", brandName,"|",medPrice, "\n");
    }
}
