LICENSE = "nokia"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-10.tar.gz"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}


