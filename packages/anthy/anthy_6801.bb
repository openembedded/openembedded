DESCRIPTION = "A Japanese input method"
AUTHOR = "Anthy Developers <anthy-dev@lists.sourceforge.jp>"
HOMEPAGE = "http://anthy.sourceforge.jp"
LICENSE = "GPL"
DEPENDS = "anthy-native"
SECTION = "libs/inputmethod"
PR = "r0"

SRC_URI = "http://osdn.dl.sourceforge.jp/anthy/15893/anthy-6801.tar.gz \
	   file://not_build_elc.patch;patch=1 \
	   file://2ch_t.patch;patch=1 \
	   file://change_anthy_dic_path.patch;patch=1 \
	   file://native-mkanthydic-mkdepgraph.patch;patch=1"
S = "${WORKDIR}/anthy-${PV}"

inherit autotools pkgconfig

PACKAGES = "${PN} libanthy0 libanthy-dev"

DESCRIPTION_anthy = "A Japanese input method (backend, dictionary and utility)"
DESCRIPTION_libanthy0 = "Anthy runtime library"
DESCRIPTION_libanthy-dev = "Anthy static library, headers and documets for developers"

# gettext

LEAD_SONAME = "libanthy.so.0"
RDEPENDS_anthy = "libanthy0"

FILES_libanthy0 = "${libdir}/libanthy.so.*	\
		   ${libdir}/libanthydic.so.*	\
		   ${libdir}/libanthyinput.so.*"
FILES_libanthy-dev = "${libdir}/libanthy* \
		      ${includedir}/anthy	\
		      ${libdir}/pkgconfig/anthy.pc"
FILES_${PN} = "${bindir}/* ${datadir}/* ${sysconfdir}/*"
