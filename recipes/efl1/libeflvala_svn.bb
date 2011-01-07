DESCRIPTION = "Vala meets the Enlightenment Foundation Libraries"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native glib-2.0 dbus dbus-glib eina eet evas ecore edje elementary"
PV = "0.5.0+svnr${SRCPV}"
PR = "r1"
PE = "1"
SRCREV = "${EFL_SRCREV}"
SRCNAME = "vala"

inherit e-base autotools pkgconfig vala

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/BINDINGS;module=${SRCNAME};proto=http;scmdata=keep \
           file://0001-eflvala-adapt-to-elementary-API-change-from-r55869.patch"

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${datadir}/libeflvala ${bindir}/*"
