DESCRIPTION = "The Libcroco project is an effort to build a generic Cascading Style Sheet (CSS) parsing and manipulation toolkit"
SECTION = "x11/utils"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
DEPENDS = "glib-2.0 libxml2"
LICENSE = "LGPL"
PR = "r1"

inherit autotools pkgconfig gnome

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/libcroco
	install -m 644 src/*.h ${STAGING_INCDIR}/libcroco/
	install -m 755 src/.libs/*so* ${STAGING_LIBDIR}/
}
