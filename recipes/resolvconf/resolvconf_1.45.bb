DESCRIPTION = "Resolvconf is a framework for keeping track of the system's \
information about currently available nameservers. It sets \
itself up as the intermediary between programs that supply \
nameserver information and programs that need nameserver \
information."
SECTION = "console/network"
LICENSE = "GPL"
AUTHOR = "Thomas Hood"
HOMEPAGE = "http://packages.debian.org/resolvconf"
DEPENDS = "bash"
RDEPENDS = "bash"

SRC_URI = "${DEBIAN_MIRROR}/main/r/resolvconf/resolvconf_${PV}.tar.gz"

do_compile () {
	:
}

do_install () {
	install -d ${D}${sysconfdir} ${D}${sbindir} ${D}${base_sbindir} ${D}${localstatedir}/run/resolvconf/interface
	install -d ${D}${mandir}/man8 ${D}${docdir}/${P}
	cp -pPR etc/* ${D}${sysconfdir}/
	install -m 0755 bin/resolvconf ${D}${base_sbindir}/
	install -m 0644 README ${D}${docdir}/${P}/
	install -m 0644 man/resolvconf.8 ${D}${mandir}/man8/
}

PACKAGE_ARCH = "all"


SRC_URI[md5sum] = "1f0b0bccb4dc0a762dacf6aca716e71d"
SRC_URI[sha256sum] = "096a0696f925334f4f9fcc87df3305999f4b9f9d630fe6f2fa0179f3d56467f3"
