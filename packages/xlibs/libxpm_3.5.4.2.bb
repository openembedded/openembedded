DESCRIPTION = "X Pixmap library."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "X-BSD"
PR = "r1"

DEPENDS = "xproto libx11 util-macros"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXpm-${PV}.tar.bz2"
S = "${WORKDIR}/libXpm-${PV}"

inherit autotools pkgconfig

do_stage () {
	install -m 0644 ${S}/include/X11/xpm.h ${STAGING_INCDIR}/X11/xpm.h
	oe_libinstall -a -so libXpm ${STAGING_LIBDIR}
}

PACKAGES =+ "sxpm cxpm"
FILES_cxpm = "${bindir}/cxpm"
FILES_sxpm = "${bindir}/sxpm"
