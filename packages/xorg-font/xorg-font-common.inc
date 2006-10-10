HOMEPAGE = "http://www.x.org"
SECTION = "x11/fonts"
LICENSE = "MIT-X"

DEPENDS = " encodings font-alias font-util-native mkfontdir-native mkfontscale-native"
RDEPENDS = "encodings font-util font-alias"

XORG_PN = "${PN}"
SRC_URI = "${XORG_MIRROR}/${@bb.data.getVar('PV', d, 1)[0:7]}/src/font/${XORG_PN}-${PV}.tar.bz2"
S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

FILES_${PN} += " ${libdir}/X11/fonts"

do_install_append() {
	find ${D}${libdir}/X11/fonts -type f -name fonts.dir | xargs rm -f
	find ${D}${libdir}/X11/fonts -type f -name fonts.scale | xargs rm -f
}

do_stage() {
	autotools_stage_all
}

pkg_postinst_${PN} () {
	set -x
	for fontdir in `find $D/usr/lib/X11/fonts -type d`; do 
		mkfontdir $fontdir
		mkfontscale $fontdir
	done
}
