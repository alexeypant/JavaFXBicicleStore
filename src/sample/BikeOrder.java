package sample;

/**
 * Created by A63556 on 2017-12-29.
 */
public class BikeOrder {
    static void validateOrder(String bikeModel, int quantity) throws TooManyBikesException{
        if ("UKRAINA".equals(bikeModel)&&(quantity > 3)){
            throw new TooManyBikesException("Can not ship " + quantity + " bikes of the model " + bikeModel);
        }
        if ("ORLENOK".equals(bikeModel)&&(quantity > 5)){
            throw new TooManyBikesException("Can not ship " + quantity + " bikes of the model " + bikeModel);
        }

    }
}
