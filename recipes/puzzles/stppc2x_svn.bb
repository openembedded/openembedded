DESCRIPTION = "stppc2x is an SDL port of Simon Tatham's Portable Puzzle Collection"
LICENSE = "GPLv2"

DEPENDS = "virtual/libsdl libsdl-image libsdl-ttf"
RDEPENDS_${PN} = "ttf-dejavu-sans-condensed"

SRCREV = "185"
PV = "1.0+svnr${SRCPV}"
PR = "r1"

FILES_${PN} = "/usr/bin /usr/share"

SRC_URI = "svn://stppc2x.googlecode.com/svn/;module=trunk;proto=http \
	   file://stppc2x-extras.tar.gz \
	   file://no-upper-mem.patch \
	   file://generic-keys.patch \
	   file://no-music.patch \
	   file://enable-fullscreen.patch \
	   file://dir-fix.patch \
	   file://stppc2x.desktop \
	   file://stppc2x.png \
	   file://Makefile"

S = "${WORKDIR}/trunk"

do_configure() {
	mv ${WORKDIR}/Makefile ${S}
	mv ${WORKDIR}/extras/help/* ${S}/help
	mv ${WORKDIR}/extras/images/* ${S}/images
}

do_install() {
	oe_runmake install DESTDIR=${D}

	install -m 0644 ${WORKDIR}/stppc2x.png ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/stppc2x.desktop ${D}${datadir}/applications
}
