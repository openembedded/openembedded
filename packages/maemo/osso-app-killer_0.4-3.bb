PR         = "r0"
LICENSE    = "GPL"

DEPENDS = "libosso"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-0.4"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0"

