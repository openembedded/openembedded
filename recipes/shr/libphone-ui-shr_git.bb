DESCRIPTION = "SHR default module for the Phone UI daemon"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libfsoframework libphone-ui evas ecore edje edje-native elementary"
SRCREV = "d51b77390b123fff86e2bd47080ff20faa610604"
PE = "1"
PV = "0.0.1+gitr${SRCPV}"
PR = "r2"

SRC_URI = "git://shr.bearstech.com/repo/libphone-ui-shr.git;protocol=http;branch=dbus-glib"
S = "${WORKDIR}/git"

inherit pkgconfig autotools autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"


do_configure_prepend() {
        autopoint --force
}

FILES_${PN} += "${libdir}/phoneui/modules/shr.so"
FILES_${PN}-dev += "${libdir}/phoneui/modules/*.la"
FILES_${PN}-dbg += "${libdir}/phoneui/modules/.debug"
FILES_${PN}-static += "${libdir}/phoneui/modules/*.a"
