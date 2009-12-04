DESCRIPTION = "Action GUI for Installer"
HOMEPAGE = "http://assassin.projects.openmoko.org/"
LICENSE = "GPL"
DEPENDS = "dbus (>= 1.1.1) glib-2.0 e-wm packagekit etk edbus eet"
RDEPENDS = "etk-theme-ninja"
PV = "0.2+svnr${SRCPV}"
PR = "r6.04"

SRC_URI = "svn://om-assassin.googlecode.com/svn/;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

EXTRA_OECONF = ""

FILES_${PN} += "${prefix}/share/*"
