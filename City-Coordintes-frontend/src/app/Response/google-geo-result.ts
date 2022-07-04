import { GoogleGeoAdressComponent } from "./google-geo-adress-component";
import { GoogleGeoGeometry } from "./google-geo-geometry";

export class GoogleGeoResult {

   constructor(public address_components: GoogleGeoAdressComponent [] = [],
    public formatted_address: String = "",
    public geometry: GoogleGeoGeometry = new GoogleGeoGeometry,
    public partial_match: boolean = false,
    public place_id: String = "",
    public types: String [] = []) {

   }
}
