DESCRIPTION = "Common X11 Keyboard layouts"
LICENSE = "MIT"
DEPENDS = "intltool xkbcomp-native"
RDEPENDS = "xkbcomp"

SRC_URI = "http://xlibs.freedesktop.org/xkbdesc/xkeyboard-config-${PV}.tar.bz2"

inherit autotools

do_stage() {
        autotools_stage_all
}

do_install_append () {
    install -d ${D}/usr/share/X11/xkb/compiled
}
