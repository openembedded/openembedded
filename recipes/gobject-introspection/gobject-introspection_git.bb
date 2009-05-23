DESCRIPTION = "GObject introspection tools and libraries"
HOMEPAGE = "http://live.gnome.org/GObjectIntrospection"
LICENSE = "GPL"
PV = "0.0.1-gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.gnome.org/gobject-introspection;protocol=git;branch=master"         
S = "${WORKDIR}/git"

inherit pkgconfig
