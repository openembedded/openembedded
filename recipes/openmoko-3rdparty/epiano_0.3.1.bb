DESCRIPTION = "A _very_ simple virtual piano written in edje. Will be replaced by something cool soon :)"
DEPENDS = "ecore evas edje fluidsynth"
LICENSE = "GPL"
SECTION = "x11/multimedia"
PV = "0.3.1"
PR = "r2"

inherit autotools pkgconfig

SRC_URI = "http://gstaedtner.net/projects/epiano/${PN}-${PV}.tar.gz"

FILES_${PN} += "${datadir}"
