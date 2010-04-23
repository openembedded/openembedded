# libxfce4util OE build file

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xfce4-dev-tools "
PR = "r2"

inherit xfce46

EXTRA_OECONF += "--disable-dependency-tracking --disable-static --with-broken-putenv=yes"

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"

FILES_${PN}-dev += " ${datadir}/xfce4/m4"

SRC_URI[md5sum] = "eac51d58179cbcadc3f802450a8ec9cd"
SRC_URI[sha256sum] = "ceecdc7d3c89f547606c2d77a8a42ccf9975c809374fab84ff0833a08510c16b"
