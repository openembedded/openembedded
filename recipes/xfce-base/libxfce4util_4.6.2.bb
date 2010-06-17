# libxfce4util OE build file

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xfce4-dev-tools "
PR = "r0"

inherit xfce46

EXTRA_OECONF += "--disable-dependency-tracking --disable-static --with-broken-putenv=yes"

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"

FILES_${PN}-dev += " ${datadir}/xfce4/m4"

SRC_URI[md5sum] = "9c3129d827d480f0906c575e7a13f1e9"
SRC_URI[sha256sum] = "ae2e7ed1000bb0b3589643a39a65e6ab64c9ee198045e7b272604986f2e18c83"
