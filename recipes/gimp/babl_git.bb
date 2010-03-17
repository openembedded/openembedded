DESCRIPTION = "Babl is a dynamic, any to any, pixel format conversion library."
LICENSE = "LGPL"

SRCREV = "5b1129a76f2f91d5f5503b078f975e55d9753312"
PV = "0.1.3"
PR = "r1+gitr${SRCREV}"
PE = "1"

inherit gnome

SRC_URI = "git://git.gnome.org/babl;protocol=git \
"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/babl-*/"
FILES_${PN}-dbg += "${libdir}/babl-*/.debug/"


