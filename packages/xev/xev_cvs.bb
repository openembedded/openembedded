PV = "0.0+cvs${SRCDATE}"
DESCRIPTION = "X Event Viewer"
HOMEPAGE = "http://freedesktop.org/wiki/Software_2fxapps"
LICENSE = "MIT"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "x11/base"
DEPENDS = "x11 xau"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xapps;module=xev \
	   file://diet-x11.patch;patch=1"
S = "${WORKDIR}/xev"

do_compile() {
	${CC} -o xev xev.c -lX11 -lXau -I${STAGING_INCDIR} -L${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${PN} ${D}${bindir}
}
