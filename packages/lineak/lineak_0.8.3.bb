DESCRIPTION = "lineakd"
SECTION = "gpe/multimedia"
HOMEPAGE = "http://lineak.sourceforge.net"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
DEPENDS = "x11 xext"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/lineak/lineakd-${PV}.tar.gz \
           file://add-zaurus-remote-support.patch;patch=1"

inherit autotools

do_install () {
	oe_runmake 'mandir=${D}/usr/share/man' 'pkglibdir=${D}/usr/lib' 'sysconfdir=${D}/etc' 'DESTDIR=${D}' install
}

PACKAGES += "${PN}-lib"

FILES_${PN}-lib += " \
  ${libdir}/liblineak*"

