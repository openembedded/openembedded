DESCRIPTION = "intone-video is a mplayer video frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone-video/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 edbus"
RDEPENDS = "mplayer lame libxv libsdl-x11"

PV = "0.13+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://intone-video.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools

do_configure_prepend() {
	rm -f "${S}/INSTALL"
	touch "${S}/INSTALL"
	sed -i 's/intone/intone-video/g' ${S}/configure.ac
	sed -i 's/\/doc\/intone$/\/share\/doc\/intone-video/g' ${S}/Makefile.am
	sed -i '/^EXTRA_DIST = $(glade_DATA)/d' ${S}/src/Makefile.am
	sed -i '/^gladedir = $(datadir)\/intone\/glade/d' ${S}/src/Makefile.am
	sed -i '/^glade_DATA = intone.glade/d' ${S}/src/Makefile.am
}

do_install_append() {
	mv ${D}/${bindir}/intone ${D}/${bindir}/intone-video
	mkdir -p "${D}/${datadir}/pixmaps"
	install -m 0644 "${S}/resources/intone-video.png" "${D}/${datadir}/pixmaps"
	mkdir -p "${D}/${datadir}/applications"
	install -m 0644 "${S}/resources/intone-video.desktop" "${D}/${datadir}/applications"
}


FILES_${PN} += "/usr/share/pixmaps/* /usr/share/applications/*"

