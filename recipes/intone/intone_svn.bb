DESCRIPTION = "intone is a mplayer frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 edbus"
RDEPENDS = "mplayer lame libxv libsdl-x11"

PV = "0.0.1+svnr${SRCREV}"
PR = "r4"

SRC_URI = "svn://intone.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools

do_configure_prepend() {
	rm -f "${S}/INSTALL"
	touch "${S}/INSTALL"
}

do_install_append() {
	mkdir -p "${D}/${datadir}/icons"
	install -m 0644 "${S}/resources/intone.png" "${D}/${datadir}/icons"
	mkdir -p "${D}/${datadir}/applications"
	install -m 0644 "${S}/resources/intone.desktop" "${D}/${datadir}/applications"
	mkdir -p "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/seek-fwd.png" "${D}/${DATADIR}/intone"
	install -m 0644 "${S}/resources/next.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/no-album-art.jpg" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/pause.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/record.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/user-home.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/playlist.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/folder.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/prev.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/seek-back.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/song.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/generic.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/play.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/resources/album.png" "${D}/${datadir}/intone"
}


FILES_${PN} += "/usr/share/intone/* /usr/share/applications/* /usr/share/icons/*"

