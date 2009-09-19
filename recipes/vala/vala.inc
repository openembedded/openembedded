DESCRIPTION = "Vala is a C#-like language dedicated to ease GObject programming. \
Vala compiles to plain C and has no runtime environment nor penalities whatsoever."
SECTION = "devel"
DEPENDS = "glib-2.0 dbus"
HOMEPAGE = "http://live.gnome.org/Vala"
LICENSE = "LGPL"
PV = "0.7.2+0.7.3-fso1"
INC_PR = "r0"

SRC_URI = "http://www.freesmartphone.org/sources/vala-${PV}.tar.gz"

inherit autotools autotools_stage

EXTRA_OECONF = "--enable-vapigen"

FILES_${PN}-doc += ${datadir}/devhelp
