DESCRIPTION = "X Event Viewer"
HOMEPAGE = "http://www.xfree86.org/current/xev.1.html"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "x11/utils"
DEPENDS = "x11 xau"
PR = "r0"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xapps;module=xev \
	   file://diet-x11.patch;patch=1"
S = "${WORKDIR}/xev"

inherit autotools

do_compile() {
	${CC} -o xev xev.c -lX11 -lXau -I${STAGING_INCDIR} -L${STAGING_LIBDIR}
}

do_install() {
  install -d ${D}/usr/bin/
	install -m 755 ${PN} ${D}/usr/bin/${PN}
}

FILES = "/usr/bin/xev"

