import { GoogleGeoLatLng } from "./google-geo-lat-lng";

export class GoogleGeoBounds {

    

    constructor(public northeast: GoogleGeoLatLng = new GoogleGeoLatLng,
        public southwest: GoogleGeoLatLng = new GoogleGeoLatLng){}
}
