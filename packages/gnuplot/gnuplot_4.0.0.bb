DESCRIPTION = "Gnuplot is a portable command-line driven interactive datafile \
(text or binary) and function plotting utility."
SECTION = "console/scientific"
LICENSE = "BSD-4"
PRIORITY = "optional"
MAINTAINER = "Philip Frampton"
DEPENDS = "libx11 libpng gd readline"
PR = "r3"

SRC_URI = "ftp://ftp.gnuplot.info/pub/gnuplot/gnuplot-${PV}.tar.gz \
	   file://subdirs.patch;patch=1 \
	   file://debian-separate-x11-package.patch;patch=1 \
	   http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz \
	   file://matrix.patch;patch=1 \
   	   file://term.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"

inherit autotools 

PACKAGES =+ "${PN}-x11"
DESCRIPTION_${PN}-x11 = "X11 display terminal for Gnuplot."
SECTION_${PN}-x11 = "x11/scientific"
FILES_${PN}-x11 = "${libexecdir} ${datadir}/applications ${datadir}/pixmaps"

acpaths = ""
EXTRA_OECONF = "--with-readline=${STAGING_LIBDIR}/.. \
		--without-plot \
		--with-png=${STAGING_LIBDIR}/.. \
		--with-gd=${STAGING_LIBDIR}/.. \
		--without-lisp-files \
		--without-tutorial"

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/qtplot-0.2/qtopia.trm ${S}/term/
}

do_install_append() {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/gnuplot.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/gnuplot.png ${D}${datadir}/pixmaps/
}
