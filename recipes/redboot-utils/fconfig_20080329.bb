DESCRIPTION = "Application to manipulate RedBoot configuration from userspace"
HOMEPAGE = "http://andrzejekiert.ovh.org/software.html.en"
SECTION = "base"
LICENSE = "GPLv2+"
PR = "r0"

SRC_URI = "http://andrzejekiert.ovh.org/software/${PN}/${PN}-${PV}.tar.gz"

S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}/${sbindir}
	install -m 755 ${S}/fconfig ${D}/${sbindir}
}

SRC_URI[md5sum] = "dac355e9f2a0f48c414c52e2034b6346"
SRC_URI[sha256sum] = "4ff0e8f07e35e46b705c0dbe9d9544ede01ea092a69e3f7db03e55a3f2bb8eb7"
