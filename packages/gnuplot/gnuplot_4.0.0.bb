DESCRIPTION = "Gnuplot is a portable command-line driven interactive datafile \
(text or binary) and function plotting utility."
SECTION = "console/scientific"
LICENSE = "BSD-4"
PRIORITY = "optional"
MAINTAINER = "Philip Frampton"
DEPENDS = "libpng gd readline"
RCONFLICTS = "gnuplot-qt gnuplot-x11"
PR = "r2"

SRC_URI = "ftp://ftp.gnuplot.info/pub/gnuplot/gnuplot-${PV}.tar.gz \
	   file://matrix.patch;patch=1 \
	   file://subdirs.patch;patch=1 \
   	   file://term.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png \
	   file://qtopia.trm"

inherit autotools 
acpaths = ""
EXTRA_OECONF = "--with-readline=${STAGING_LIBDIR}/.. \
		--without-plot \
		--with-png=${STAGING_LIBDIR}/.. \
		--with-gd=${STAGING_LIBDIR}/.. \
		--without-lisp-files \
		--without-tutorial \
		--without-x"

do_compile_prepend(){
	install -m 0644 ${WORKDIR}/qtopia.trm ${S}/term/
}

do_install_append() {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/gnuplot.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/gnuplot.png ${D}${datadir}/pixmaps/
}
