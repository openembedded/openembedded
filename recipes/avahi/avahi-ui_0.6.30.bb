require avahi.inc
PR = "${INC_PR}.0"

DEPENDS += "avahi gtk+"

AVAHI_GTK = "--enable-gtk --disable-gtk3"

S = "${WORKDIR}/avahi-${PV}"

PACKAGES = "${PN} ${PN}-utils ${PN}-dbg"

FILES_${PN} = "${libdir}/libavahi-ui*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/libavah-ui*"

FILES_${PN}-utils = "${bindir}/b* ${datadir}/application/b*"

SRC_URI[md5sum] = "e4db89a2a403ff4c47d66ac66fad1f43"
SRC_URI[sha256sum] = "f9e4316c2339d0020726edd846d01bee0c39980906db0c247479e5807457ff1f"

