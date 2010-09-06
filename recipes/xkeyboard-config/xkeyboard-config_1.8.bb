DESCRIPTION = "Common X11 Keyboard layouts"
LICENSE = "MIT"
DEPENDS = "intltool xkbcomp-native"
RDEPENDS_${PN} = "xkbcomp"
PR = "r0"

SRC_URI = "http://xlibs.freedesktop.org/xkbdesc/xkeyboard-config-${PV}.tar.bz2 \
           file://abnt2-fixes.patch"

inherit autotools

do_install_append () {
    install -d ${D}/usr/share/X11/xkb/compiled
    cd ${D}${datadir}/X11/xkb/rules && ln -sf base xorg
}

FILES_${PN} += "${datadir}/X11/xkb"

SRC_URI[md5sum] = "37ae41628cd2ce35d202d30b1820c8ba"
SRC_URI[sha256sum] = "7dc3e6ca00adb105f46e40f8382e83d50b3fcd626bc8654293dae8b1e80506ce"
