DESCRIPTION = "Sugar artwork"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "sugar icon-slicer-native"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar-artwork/${PN}-${PV}.tar.bz2 \
           file://icon-slicer.diff;patch=1"

inherit autotools distutils-base

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

FILES_${PN} += "${datadir}/${PN} \
		${datadir}/icons \
		${datadir}/themes \
		${sysconfdir} "

FILES_${PN}-dbg += "${libdir}/gtk-2.0/2.*/engines/.debug"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

