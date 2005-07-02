PR         = "r0"
LICENSE    = ""
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = "gtk+-2.6.4-1.osso7"
SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-1.20"

inherit pkgconfig autotools
