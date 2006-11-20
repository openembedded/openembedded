PR         = "r0"
LICENSE    = "GPL"
PROVIDES   = "esd"
RPROVIDES_${PN}  = "esd"

DEPENDS = "audiofile osso-dsp-headers"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.orig.tar.gz"

S = "${WORKDIR}/esd"

inherit autotools pkgconfig

