DESCRIPTION = "The OpenMoko Tasks Application"
SECTION = "openmoko/pim"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+ libglade eds-dbus openmoko-libs"
RDEPENDS = "libedata-cal"
PV = "0.1+svnr${SRCREV}"
PR = "r0"

inherit gnome autotools pkgconfig gtk-icon-cache

SRC_URI = "svn://svn.o-hand.com/repos/tasks/;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

EXTRA_OECONF = "--enable-omoko --disable-gtk"

