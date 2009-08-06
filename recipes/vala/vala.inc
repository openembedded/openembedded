DESCRIPTION = "Vala is a C#-like language dedicated to ease GObject programming. \
Vala compiles to plain C and has no runtime environment nor penalities whatsoever."
SECTION = "devel"
DEPENDS = "glib-2.0 dbus"
HOMEPAGE = "http://vala-project.org"
LICENSE = "LGPL"
INC_PR = "r0"

SRC_URI = "http://www.freesmartphone.org/sources/vala-${VALA_FSO_RELEASE}.tar.gz"
S = "${WORKDIR}/vala-${VALA_FSO_RELEASE}"

inherit autotools_stage

EXTRA_OECONF = "--enable-vapigen"

FILES_${PN}-doc += ${datadir}/devhelp
