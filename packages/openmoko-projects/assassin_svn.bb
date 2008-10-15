DESCRIPTION = "Action GUI for Installer"
HOMEPAGE = "http://assassin.projects.openmoko.org/"
LICENSE = "GPL"
DEPENDS = "dbus (>= 1.1.1) glib-2.0 e-wm packagekit etk edbus eet"
PV = "0.2+svnr${SRCREV}"
PR = "r6"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=assassin;proto=https"

S = "${WORKDIR}/assassin"

inherit autotools pkgconfig

EXTRA_OECONF = ""

FILES_${PN} += "${prefix}/share/*"
