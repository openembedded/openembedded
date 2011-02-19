DESCRIPTION = "Common X11 Keyboard layouts"
LICENSE = "MIT"
DEPENDS = "intltool-native xkbcomp-native"
RDEPENDS_${PN} = "xkbcomp"
INC_PR = "r6"

SRC_URI = "http://xlibs.freedesktop.org/xkbdesc/xkeyboard-config-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

do_install_append () {
    install -d ${D}${datadir}/X11/xkb/compiled
    cd ${D}${datadir}/X11/xkb/rules && ln -sf base xorg
}

FILES_${PN} += "${datadir}/X11/xkb"
