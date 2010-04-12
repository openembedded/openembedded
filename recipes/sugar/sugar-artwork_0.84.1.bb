DESCRIPTION = "Sugar artwork"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "sugar icon-slicer-native"
RDEPENDS = "ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-sans-condensed \
            ttf-dejavu-serif ttf-dejavu-serif-condensed \
            python-pycairo fontconfig freetype python-pygtk"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-artwork/${PN}-${PV}.tar.bz2 "

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


SRC_URI[md5sum] = "d28b847a24aa23a1b6949aa6a7873560"
SRC_URI[sha256sum] = "2dc71acc88da545e6a217fd4749dc39a9d59e9f2f768bd67ea201999e55f302a"
