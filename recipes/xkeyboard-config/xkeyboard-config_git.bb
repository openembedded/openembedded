DESCRIPTION = "Common X11 Keyboard layouts"
LICENSE = "MIT"
DEPENDS = "intltool xkbcomp-native"
RDEPENDS_${PN} = "xkbcomp"
SRCREV = "547ae8589afb208d7b44ffe1e0ff7aba466c2ee3"
PV = "2.0+gitr${SRCPV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

SRC_URI = "git://anongit.freedesktop.org/xkeyboard-config;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit autotools

do_install_append () {
    install -d ${D}/usr/share/X11/xkb/compiled
    cd ${D}${datadir}/X11/xkb/rules && ln -sf base xorg
}

FILES_${PN} += "${datadir}/X11/xkb"
