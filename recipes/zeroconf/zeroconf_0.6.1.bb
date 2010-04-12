DESCRIPTION = "IPv4 link-local address allocator"
HOMEPAGE = "http://www.progsoc.org/~wildfire/zeroconf/"
LICENSE = "GPL"
SECTION = "net"
PRIORITY = "optional"

PR = "r0"

SRC_URI = "http://www.progsoc.org/~wildfire/zeroconf/download/${PN}-${PV}.tar.gz \
	   file://debian-zeroconf.patch;patch=1 \
	   file://busybox.patch;patch=1 \
	   file://zeroconf-default"

do_install () {
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}/network/if-up.d
	install -d ${D}${sysconfdir}/default
	install -c -m 755 ${S}/zeroconf ${D}${sbindir}/zeroconf
	install -c -m 755 ${S}/zeroconf.sh ${D}${sysconfdir}/zeroconf
	install -c -m 755 ${S}/debian-zeroconf ${D}${sysconfdir}/network/if-up.d/zeroconf
	install -c ${WORKDIR}/zeroconf-default ${D}${sysconfdir}/default/zeroconf
}

SRC_URI[md5sum] = "31ac40fdaf24b3e666ed83c1320dd7a5"
SRC_URI[sha256sum] = "3e93416ad44202c2952a1342dad12f2ad0e61dd3f1c59110d9ad8cb1d4c639e5"
