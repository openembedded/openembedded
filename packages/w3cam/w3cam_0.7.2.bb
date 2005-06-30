DESCRIPTION = "a small and fast cgi program to retrieve images from a V4L device."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
DEPENDS="jpeg"
LICENSE = "GPLV2"
PR = "r0"

SRC_URI = "http://mpx.freeshell.net/w3cam-0.7.2.tar.gz \
	   file://staticpaths.patch;patch=1"

S = "${WORKDIR}/w3cam-0.7.2/"

inherit autotools

LDFLAGS += "-L${STAGING_LIBDIR}"
CFLAGS += "-L${STAGING_LIBDIR} -I${STAGING_INCDIR}"

EXTRA_OECONF = "--without-x --without-ttf-inc"

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1
	install -d ${D}usr/cgi-bin
	install -m 0755 ${S}w3camd/w3camd ${D}${sbindir}/w3camd
	install -m 0755 ${S}w3cam.cgi ${D}usr/cgi-bin/w3camd.cgi
	install -m 0755 ${S}vidcat ${D}${bindir}/vidcat
	install -m 0644 ${S}vidcat.1 ${D}${mandir}/man1/vidcat.1
}

