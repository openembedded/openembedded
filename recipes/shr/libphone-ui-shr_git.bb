DESCRIPTION = "SHR default module for the Phone UI daemon"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libphone-ui evas ecore edje edje-native elementary"
SRCREV = "9f1f52bd8b314e8e46e9713f823fb17ba32ee7f5"
PV = "0.0.0+gitr${SRCPV}"
PR = "r5"

SRC_URI = "git://shr.bearstech.com/repo/libphone-ui-shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit pkgconfig autotools autotools_stage

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"


do_configure_prepend() {
        autopoint --force
}

FILES_${PN} += "${libdir}/phoneui/modules/shr.so"
FILES_${PN}-dbg += "${libdir}/phoneui/modules/.debug"
