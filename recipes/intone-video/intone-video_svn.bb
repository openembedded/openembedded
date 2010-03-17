DESCRIPTION = "intone-video is a mplayer video frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone-video/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 edbus"
RDEPENDS = "mplayer lame libxv libsdl-x11"

SRCREV = "12"
PV = "0.13+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://intone-video.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit autotools

do_install_append() {
	install -d "${D}/${datadir}/pixmaps"
	install -m 0644 "${S}/resources/intone-video.png" "${D}/${datadir}/pixmaps"
	install -d "${D}/${datadir}/applications"
	install -m 0644 "${S}/resources/intone-video.desktop" "${D}/${datadir}/applications"
}


FILES_${PN} += "/usr/share/pixmaps/* /usr/share/applications/*"

