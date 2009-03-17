DESCRIPTION = "Hildon widget library"
LICENSE = "LGPL"

DEPENDS = "gconf-dbus esound gtk+"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--with-maemo-gtk=no"

do_stage() {
        autotools_stage_all
}

