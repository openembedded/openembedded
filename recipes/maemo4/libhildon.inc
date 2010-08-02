DESCRIPTION = "Hildon widget library"
LICENSE = "LGPL"

DEPENDS = "gconf esound gtk+"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--with-maemo-gtk=no"

