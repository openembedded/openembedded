DESCRIPTION = "Common X11 Keyboard layouts"
LICENSE = "MIT"
DEPENDS = "intltool-native xkbcomp-native glib-2.0-native"
RDEPENDS_${PN} = "xkbcomp"
INC_PR = "r8"

SRC_URI = "http://xlibs.freedesktop.org/xkbdesc/xkeyboard-config-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECONF += "--with-xkb-rules-symlink=xorg"

inherit autotools

FILES_${PN} += "${datadir}/X11/xkb"
