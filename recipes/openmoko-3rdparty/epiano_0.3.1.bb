DESCRIPTION = "A _very_ simple virtual piano written in edje. Will be replaced by something cool soon :)"
DEPENDS = "ecore evas edje fluidsynth"
LICENSE = "GPL"
SECTION = "x11/multimedia"
PV = "0.3.1"
PR = "r2"

inherit autotools pkgconfig

SRC_URI = "http://gstaedtner.net/projects/epiano/${PN}-${PV}.tar.gz"

FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "7966c489329cff971d97441d69abe19b"
SRC_URI[sha256sum] = "17e02481c2fec1912241c6a12e8a277f87c3664b73c3a0946ea93461c5a937ae"
