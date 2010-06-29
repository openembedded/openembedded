DESCRIPTION = "SHR default module for the Phone UI daemon"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libfsoframework libphone-ui evas ecore edje edje-native elementary"
SRCREV = "29f50f4482feec132e30c075e7c2a36ce09d3638"
PV = "0.0.0+gitr${SRCPV}"
PR = "r8"

SRC_URI = "git://shr.bearstech.com/repo/libphone-ui-shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit pkgconfig autotools autotools_stage

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"


do_configure_prepend() {
        autopoint --force
}

FILES_${PN} += "${libdir}/phoneui/modules/shr.so"
FILES_${PN}-dev += "${libdir}/phoneui/modules/*.la"
FILES_${PN}-dbg += "${libdir}/phoneui/modules/.debug"
FILES_${PN}-static += "${libdir}/phoneui/modules/*.a"
