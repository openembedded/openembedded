DESCRIPTION = "Mokoko - a simple media player"
HOMEPAGE = "http://code.google.com/p/om-mediaplayer/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "gstreamer"
RDEPENDS_${PN} = "gstreamer"

SRCREV = "127"
PV = "0.1+svnr${SRCPV}"
PR = "r3"

SRC_URI = "svn://om-mediaplayer.googlecode.com/svn/;module=trunk;proto=http"

S = "${WORKDIR}/trunk/mokoko"

inherit autotools

do_configure_prepend () {
        autopoint --force
}

FILES_${PN} += "${prefix}/etc/*"
