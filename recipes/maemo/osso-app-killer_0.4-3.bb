PR         = "r0"
LICENSE    = "GPL"

DEPENDS = "libosso"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-0.4"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0"


SRC_URI[md5sum] = "54a7df1fcef0cc67f83797bd6b882195"
SRC_URI[sha256sum] = "011efde2376624c70760417d0ca75a9a1fde1ebb6f925326b99ba3586a4b50c1"
