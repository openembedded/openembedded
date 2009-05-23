DESCRIPTION = "frameworkd EFL phonegui"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui etk evas ecore edje edje-native elementary"
PV = "0.0.2+gitr${SRCPV}"
PR = "r31"

inherit shr pkgconfig autotools autotools_stage

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

do_configure_prepend() {
        autopoint --force
}

