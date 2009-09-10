DESCRIPTION = "intone is a mplayer frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 edbus libvorbis id3lib"
RDEPENDS = "mplayer lame libxv libsdl-x11"

PV = "0.66+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://intone.googlecode.com/svn/trunk;module=.;proto=http \
file://vorbis-include-id3tag.patch;pnum=1;patch=1;maxrev=18"
S = "${WORKDIR}"

inherit autotools

do_configure_prepend() {
	rm -f "${S}/INSTALL"
	touch "${S}/INSTALL"
	sed -i 's/\/doc\/intone$/\/share\/doc\/intone/g' ${S}/Makefile.am
	sed -i '/^EXTRA_DIST = $(glade_DATA)/d' ${S}/src/Makefile.am
	sed -i '/^gladedir = $(datadir)\/intone\/glade/d' ${S}/src/Makefile.am
	sed -i '/^glade_DATA = intone.glade/d' ${S}/src/Makefile.am
}

do_install_append() {
	mkdir -p "${D}/${datadir}/pixmaps"
	install -m 0644 "${S}/resources/intone.png" "${D}/${datadir}/pixmaps"
	mkdir -p "${D}/${datadir}/applications"
	install -m 0644 "${S}/resources/intone.desktop" "${D}/${datadir}/applications"
	mkdir -p "${D}/${datadir}/intone"
	for ico in "${S}/resources/"*.png "${S}/resources/"*.jpg; do
		if [ "$(basename $ico)" != "intone.png" ]; then
			install -m 0644 $ico "${D}/${datadir}/intone"
		fi
	done
}


FILES_${PN} += "/usr/share/intone/* /usr/share/applications/* /usr/share/pixmaps/*"

