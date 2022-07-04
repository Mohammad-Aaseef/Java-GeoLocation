import { GoogleGeoBounds } from "./google-geo-bounds";
import { GoogleGeoLatLng } from "./google-geo-lat-lng";

export class GoogleGeoGeometry {

    // public bounds: GoogleGeoBounds = new GoogleGeoBounds;
    // public location: GoogleGeoLatLng = new GoogleGeoLatLng;
    // public location_type: String = "";
    // public viewport: GoogleGeoBounds = new GoogleGeoBounds;

    constructor(public bounds: GoogleGeoBounds = new GoogleGeoBounds,
        public location: GoogleGeoLatLng = new GoogleGeoLatLng,
        public location_type: String = "",
        public viewport: GoogleGeoBounds = new GoogleGeoBounds){}
	
}
