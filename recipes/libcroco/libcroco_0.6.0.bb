DESCRIPTION = "The Libcroco project is an effort to build a generic Cascading Style Sheet (CSS) parsing and manipulation toolkit"
SECTION = "x11/utils"
DEPENDS = "glib-2.0 libxml2"
LICENSE = "LGPL"
PR = "r2"

inherit autotools pkgconfig gnome

SRC_URI_append = " file://croco.patch;patch=1 "

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/libcroco
	install -m 644 src/*.h ${STAGING_INCDIR}/libcroco/
	install -m 755 src/.libs/*so* ${STAGING_LIBDIR}/
}

SRC_URI[archive.md5sum] = "78fb2bf78d469df83b1fc94ce196c1c4"
SRC_URI[archive.sha256sum] = "39d348bc3b821f7042c4018555c3beffaf887a42e8b084c1bb521c96421c38b2"
