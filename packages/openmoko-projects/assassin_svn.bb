DESCRIPTION = "Action GUI for Installer"
HOMEPAGE = "http://assassin.projects.openmoko.org/"
LICENSE = "GPL"
DEPENDS = "dbus (>= 1.1.1) glib-2.0 e-wm packagekit etk edbus"
PV = "0.2+svn${SRCREV}"
PR = "r4"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=assassin;proto=https"

S = "${WORKDIR}/assassin"

inherit autotools pkgconfig

EXTRA_OECONF = ""

FILES_${PN} += "${prefix}/share/*"
