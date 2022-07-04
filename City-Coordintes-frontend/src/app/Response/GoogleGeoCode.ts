import { GoogleGeoResult } from "./google-geo-result";

export class GoogleGeoCode {

    constructor(   public status: String = "",
    public results: GoogleGeoResult [] = [],
    public exclude_from_slo: boolean = false,
    public error_message: String = ""){

    }
}
