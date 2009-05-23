DESCRIPTION = "GObject-introspection allows you to create bindings for other programming languages for your GObject based libraries."
SECTION = "devel"
HOMEPAGE ="http://live.gnome.org/GObjectIntrospection"
LICENSE = "GPLv2+"

MAJV = "${@bb.data.getVar('PV',d,1)[:3]}"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gobject-introspection/${MAJV}/gobject-introspection-${PV}.tar.bz2"

S = "${WORKDIR}/gobject-introspection-${PV}"

inherit pkgconfig autotools autotools_stage lib_package

FILES_${PN}-doc += ${datadir}/docs

#do_configure() {
#	echo "--- doing the configure"
#	#rm -rf  m4/libtool.m4
#	libtoolize --force --automake
#	#gnu-configize --force
#	autotools_do_configure
#}


