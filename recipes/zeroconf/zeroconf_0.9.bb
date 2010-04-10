DESCRIPTION = "IPv4 link-local address allocator"
AUTHOR = "Anand Kumria <wildfire@progsoc.uts.edu.au>"
HOMEPAGE = "http://www.progsoc.org/~wildfire/zeroconf/"
LICENSE = "GPL"
SECTION = "net"
PRIORITY = "optional"

PR = "r2"

SRC_URI = "http://www.progsoc.org/~wildfire/zeroconf/download/${PN}-${PV}.tar.gz \
	   file://zeroconf-default \
	   file://zeroconf-ldflags.patch;patch=1 \
	   file://zeroconf-limits.h.patch;patch=1 \
	   file://debian-zeroconf"

do_install () {
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}/network/if-up.d
	install -d ${D}${sysconfdir}/default
	install -c -m 755 ${S}/zeroconf ${D}${sbindir}/zeroconf
	install -c -m 755 ${WORKDIR}/debian-zeroconf ${D}${sysconfdir}/network/if-up.d/zeroconf
	install -c ${WORKDIR}/zeroconf-default ${D}${sysconfdir}/default/zeroconf
}

SRC_URI[md5sum] = "bdafb16b008ebb5633e4e581f77821d2"
SRC_URI[sha256sum] = "a8c74df127753e2310fa1e072f3c9ca44a404bb0bbce9cfec7a84c6dff8bec7b"
