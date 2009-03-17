HOMEPAGE = "http://www.x.org"
SECTION = "x11/fonts"
LICENSE = "MIT-X"

DEPENDS = " encodings font-alias font-util-native mkfontdir-native mkfontscale-native"
RDEPENDS = "encodings font-util font-alias"

XORG_PN = "${PN}"
SRC_URI = "${XORG_MIRROR}/individual/font/${XORG_PN}-${PV}.tar.bz2"
S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

FILES_${PN} += " ${libdir}/X11/fonts"

do_configure_prepend() {
        if [ -f "${S}"/configure.ac ] ; then
                sed -i "s#^MAPFILES_PATH=.*#MAPFILES_PATH=\"${STAGING_DIR_TARGET}/\$(pkg-config --variable=mapdir fontutil)\"#g" "${S}"/configure.ac
        fi
}

EXTRA_OEMAKE += "FCCACHE=/bin/true"
do_install_append() {
	find ${D}${libdir}/X11/fonts -type f -name fonts.dir | xargs rm -f
	find ${D}${libdir}/X11/fonts -type f -name fonts.scale | xargs rm -f
}

do_stage() {
	autotools_stage_all
}

PACKAGE_ARCH = "all"

pkg_postinst_${PN} () {
	set -x
	for fontdir in `find $D/usr/lib/X11/fonts -type d`; do 
		mkfontdir $fontdir
		mkfontscale $fontdir
	done
}
