DESCRIPTION = "BOOTP and DHCP client for automatic IP configuration"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "popt"

S = "${WORKDIR}/pump-${PV}"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/p/pump/pump_0.8.24.orig.tar.gz \
           file://debian.patch;patch=1"

do_compile() {
        oe_runmake pump 
}

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 ${S}/pump ${D}${base_sbindir}/pump
}
