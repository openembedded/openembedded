DESCRIPTION = "A Japanese input method"
DESCRIPTION_anthy = "A Japanese input method (backend, dictionary and utility)"
DESCRIPTION_libanthy0 = "Anthy runtime library"
DESCRIPTION_libanthy-dev = "Anthy static library, headers and documets for developers"
AUTHOR = "Anthy Developers <anthy-dev@lists.sourceforge.jp>"
HOMEPAGE = "http://anthy.sourceforge.jp"
SECTION = "inputmethods"
SECTION_libanthy0 = "libs/inputmethods"
SECTION_libanthy-dev = "devel/libs"
LICENSE = "GPL"
DEPENDS = "anthy-native"
PR = "r3"

SRC_URI = "http://osdn.dl.sourceforge.jp/anthy/29142/anthy-9100e.tar.gz \
           file://not_build_elc.patch;patch=1 \
           file://2ch_t.patch;patch=1 \
           file://native-helpers.patch;patch=1"

inherit autotools pkgconfig

# gettext

LEAD_SONAME = "libanthy.so.0"
RDEPENDS_anthy = "libanthy0"

do_stage() {
	autotools_stage_all
}

PACKAGES += "${PN}-el libanthy0 libanthy-dev"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_libanthy0 = "${libdir}/libanthy.so.*	\
           		   ${libdir}/libanthydic.so.*	\
		           ${libdir}/libanthyinput.so.*"
FILES_libanthy-dev = "${libdir}/libanthy*.la \
                      ${libdir}/libanthy*.a \
                      ${libdir}/libanthy*.so \
	 	              ${includedir}/anthy	\
		              ${libdir}/pkgconfig/anthy.pc"
FILES_${PN}-el = "${datadir}/emacs/*"
FILES_${PN} = "${datadir}/* \
               ${bindir}/* \
               ${sysconfdir}/anthy-conf"
