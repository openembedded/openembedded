LICENSE = "nokia"

# This is proprietary software in Chinook, so we have to stay with the last released
# free version.
SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-10.tar.gz"

inherit autotools pkgconfig

do_stage() {
  autotools_stage_all
}


