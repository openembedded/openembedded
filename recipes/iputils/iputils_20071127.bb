SECTION = "console/network"
DESCRIPTION = "Utilities for the IP protocol, including traceroute6, \
tracepath, tracepath6, ping, ping6 and arping."
SECTION = "console/network"
LICENSE ="BSD"
DEPENDS = "docbook-utils-native"

PR = "r1"

DEFAULT_PREFERENCE_angstrom = "2"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/i/iputils/iputils_${PV}.orig.tar.gz \
           file://debian/fix-dead-host-ping-stats.diff;patch=1 \
           file://debian/add-icmp-return-codes.diff;patch=1 \
           file://debian/use_gethostbyname2.diff;patch=1 \
           file://debian/fix-cmsghdr-offset-bug.diff;patch=1 \
           file://debian/cleanup-docbook-formatting.diff;patch=1 \
           file://debian/targets.diff;patch=1 \
           file://debian/fix-tracepath-docs.diff;patch=1 \
           file://debian/fix-arping-timeouts.diff;patch=1 \
"

S = "${WORKDIR}/iputils_20071127.orig"

PACKAGES += "${PN}-ping ${PN}-ping6 ${PN}-arping ${PN}-tracepath ${PN}-tracepath6 ${PN}-traceroute6"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_{PN} += "${PN}-ping ${PN}-ping6 ${PN}-arping ${PN}-tracepath ${PN}-tracepath6 ${PN}-traceroute6"

FILES_${PN}		= ""
FILES_${PN}-ping	= "${base_bindir}/ping.${PN}"
FILES_${PN}-ping6	= "${base_bindir}/ping6.${PN}"
FILES_${PN}-arping	= "${bindir}/arping"
FILES_${PN}-tracepath	= "${bindir}/tracepath"
FILES_${PN}-tracepath6	= "${bindir}/tracepath6"
FILES_${PN}-traceroute6	= "${bindir}/traceroute6"
FILES_${PN}-doc		= "${mandir}/man8"

do_compile () {
	oe_runmake 'CC=${CC}' \
		   KERNEL_INCLUDE="${STAGING_INCDIR}" \
		   LIBC_INCLUDE="${STAGING_INCDIR}" all man
}

do_install () {
	install -m 0755 -d ${D}${base_bindir} ${D}${bindir} ${D}${mandir}/man8
	# SUID root programs
	install -m 4555 ping ${D}${base_bindir}/ping.${PN}
	install -m 4555 ping6 ${D}${base_bindir}/ping6.${PN}
	install -m 4555 traceroute6 ${D}${bindir}/
	# Other programgs
	for i in arping tracepath tracepath6; do
	  install -m 0755 $i ${D}${bindir}/
	done
	# Manual pages for things we build packages for
	for i in tracepath.8 traceroute6.8 ping.8 arping.8; do
	  install -m 0644 doc/$i ${D}${mandir}/man8/ || true
	done
}

# Busybox also provides ping and ping6, so use update-alternatives
# Also fixup SUID bit for applications that need it
pkg_postinst_${PN}-ping () {
	chmod 4555 ${base_bindir}/ping.${PN}
	update-alternatives --install ${base_bindir}/ping ping ping.${PN} 100
}
pkg_prerm_${PN}-ping () {
	update-alternatives --remove ping ping.${PN}
}

pkg_postinst_${PN}-ping6 () {
	chmod 4555 ${base_bindir}/ping6.${PN}
	update-alternatives --install ${base_bindir}/ping6 ping6 ping6.${PN} 100
}
pkg_prerm_${PN}-ping6 () {
	update-alternatives --remove ping6 ping6.${PN}
}

pkg_postinst_${PN}-traceroute6 () {
	chmod 4555 ${bindir}/traceroute6
}

SRC_URI[md5sum] = "a1d0aca33da380d6045c5c0e5002c09d"
SRC_URI[sha256sum] = "9e4ab143828fefb3b67ce2bc3ad63a91cacc45d97161822915778683fb80343b"
