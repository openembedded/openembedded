DESCRIPTION = "frameworkd EFL phonegui 2"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui etk evas ecore edje edje-native elementary"
PV = "0.0.1+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://shr.bearstech.com/repo/libframeworkd-phonegui-efl2.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit pkgconfig autotools autotools_stage

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"


do_configure_prepend() {
        autopoint --force
}

