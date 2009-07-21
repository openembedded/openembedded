DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
LICENSE = "LGPL"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libgee/0.1/libgee-${PV}.tar.bz2 \
           file://no-tests.patch;patch=1"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
	install -d ${STAGING_DATADIR}/vala/vapi 
	install -m 0644 ${S}/gee/gee-1.0.vapi ${STAGING_DATADIR}/vala/vapi
}

FILES_${PN} += "${datadir}/vala"
