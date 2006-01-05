DESCRIPTION = "Set various aspects of Philips (and compatible) WebCams."
SECTION = "console"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
HOMEPAGE = "http://www.vanheusden.com/setpwc/"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.vanheusden.com/setpwc/setpwc-${PV}.tgz \
	   file://Makefile.patch;patch=1"

inherit autotools

INHIBIT_AUTO_STAGE = "1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/setpwc ${D}${bindir}/setpwc
}
