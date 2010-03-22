DESCRIPTION = "Vala meets the Enlightenment Foundation Libraries"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native glib-2.0 dbus dbus-glib eina eet evas ecore edje elementary"
PV = "0.5.0+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/BINDINGS;module=vala;proto=http"
S = "${WORKDIR}/vala"

inherit autotools_stage pkgconfig vala

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${datadir}/libeflvala ${bindir}/*"
