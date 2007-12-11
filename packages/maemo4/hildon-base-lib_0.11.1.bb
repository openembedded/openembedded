LICENSE = "LGPL"

DEPENDS = "gtk+ virtual/libx11"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-1.tar.gz"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}


