DESCRIPTION = "Set various aspects of Philips (and compatible) WebCams."
SECTION = "console"
PRIORITY = "optional"
HOMEPAGE = "http://www.vanheusden.com/setpwc/"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.vanheusden.com/setpwc/setpwc-${PV}.tgz"

TARGET_CC_ARCH += " ${LDFLAGS}"

inherit autotools

INHIBIT_AUTO_STAGE = "1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/setpwc ${D}${bindir}/setpwc
}

SRC_URI[md5sum] = "1bc721cdfcbac24027e2afc93685d29f"
SRC_URI[sha256sum] = "855dcf73bda36e6445119f0b1b0a63464ba237d82794f115912464f8aebc5ed1"
