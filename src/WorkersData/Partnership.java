package WorkersData;

import java.time.LocalDate;
import java.util.List;

abstract public class Partnership extends General{
    private static String partnerShipName;
    private static LocalDate creationDate = LocalDate.now();
    private static boolean internationality;

    Partnership(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality) {
        super(counterId);
        Partnership.partnerShipName = partnerShipName;
        Partnership.creationDate = creationDate;
        Partnership.internationality = internationality;
    }

    public static String getPartnerShipName() {
        return partnerShipName;
    }

    public static void setPartnerShipName(String partnerShipName) {
        Partnership.partnerShipName = partnerShipName;
    }

    public static LocalDate getCreationDate() {
        return creationDate;
    }

    public static void setCreationDate(LocalDate creationDate) {
        Partnership.creationDate = creationDate;
    }

    public static void setInternationality(boolean internationality) {
        Partnership.internationality = internationality;
    }
    public static boolean getInternationality(){
        return internationality;
    }
}
