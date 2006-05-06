DESCRIPTION = "X Pixmap library."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "X-BSD"
PR = "r1"

DEPENDS = "xproto libx11 util-macros"

XORG_PN = "libXpm"

include xorg-xlibs.inc

do_stage () {
	install -m 0644 ${S}/include/X11/xpm.h ${STAGING_INCDIR}/X11/xpm.h
	oe_libinstall -a -so libXpm ${STAGING_LIBDIR}
}

PACKAGES =+ "sxpm cxpm"
FILES_cxpm = "${bindir}/cxpm"
FILES_sxpm = "${bindir}/sxpm"
