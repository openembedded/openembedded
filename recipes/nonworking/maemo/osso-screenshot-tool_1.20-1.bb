PR         = "r0"
LICENSE    = ""

DEPENDS = "gtk+-2.6.4-1.osso7"
SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-1.20"

inherit pkgconfig autotools

SRC_URI[md5sum] = "d07be50f058ef53fbdc5c1720f26b9ad"
SRC_URI[sha256sum] = "c01553daef241e425afd17f421f0cd2b8bf8ba03f55f5a3e30192c36511aa199"
