DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
HOMEPAGE = "http://www.emma-soft.com/projects/epdfview/"
LICENSE = "GPLv2"
SECTION = "x11/applications"
DEPENDS = "poppler gtk+ cups"

PV = "0.1.7+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.emma-soft.com/epdfview;module=trunk;proto=svn \
	  "
SRC_URI_append_shr = "file://acroread.png \
                     "

S = "${WORKDIR}/trunk"

inherit autotools

do_configure_prepend() {
	sh autogen.sh
}

do_compile_append () {
	sed -i 's|\$.*prefix./|/usr/|' data/epdfview.desktop
}

do_compile_append_shr () {
	sed -i 's/Icon=.*/Icon=acroread/' data/epdfview.desktop
}

do_install_append_shr () {
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/acroread.png ${D}${datadir}/pixmaps/
}

FILES_${PN}_append_shr = "${datadir}/pixmaps/acroread.png \
                         "
