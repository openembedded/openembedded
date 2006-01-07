PV = "0.0+cvs${SRCDATE}"
LICENSE = "XFree86"

SECTION = "x11/libs"
DEPENDS = "x11 xext xxf86dgaext"
DESCRIPTION = "Xxf86dga extension library."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xxf86dga"
S = "${WORKDIR}/Xxf86dga"

inherit autotools pkgconfig 

do_stage() {
	oe_libinstall -so -a libXxf86dga ${STAGING_LIBDIR}
}
