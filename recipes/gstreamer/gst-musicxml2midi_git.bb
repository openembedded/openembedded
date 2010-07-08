DESCRIPTION = "musicxml2midi provides an element that converts MusicXML in to MIDI format"
LICENSE = "LGPLv2"

DEPENDS = "gstreamer libxml2"

inherit autotools

PV = "0.10.0.1"
PR_append = "+gitr${SRCPV}"
SRCREV = "7d7453fdbe81653c203db9c29cb0bfc9e06c6caa"
SRC_URI = "git://github.com/Elleo/${PN}.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN}-dbg += "${libdir}/gstreamer-*/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-*/*.la"
FILES_${PN}-static += "${libdir}/gstreamer-*/*.a"
FILES_${PN} += "${libdir}/gstreamer-*/*.so"

