DESCRIPTION = "Gnuplot is a portable command-line driven interactive datafile \
(text or binary) and function plotting utility."
SECTION = "console/scientific"
LICENSE = "BSD-4"
PRIORITY = "optional"
DEPENDS = "pango cairo virtual/libx11 libpng gd readline"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gnuplot/${PN}-${PV}.tar.gz \
	   file://subdirs.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"

inherit autotools

acpaths = ""
EXTRA_OECONF = "--with-readline=${STAGING_LIBDIR}/.. \
		--without-plot \
		--with-png=${STAGING_LIBDIR}/.. \
		--with-gd=${STAGING_LIBDIR}/.. \
		--without-lisp-files \
		--without-tutorial"

do_install_append() {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/gnuplot.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/gnuplot.png ${D}${datadir}/pixmaps/
}


PACKAGES =+ "${PN}-x11-dbg ${PN}-x11"
DESCRIPTION_${PN}-x11 = "X11 display terminal for Gnuplot."
SECTION_${PN}-x11 = "x11/scientific"
FILES_${PN}-x11 = "${libexecdir} ${datadir}/applications ${datadir}/pixmaps ${libdir}/X11 "

FILES_${PN} += "${datadir}/texmf"
FILES_${PN}-x11-dbg += "${libexecdir}/gnuplot/*/.debug"


