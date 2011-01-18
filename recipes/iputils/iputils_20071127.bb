SECTION = "console/network"
DESCRIPTION = "Utilities for the IP protocol, including traceroute6, \
tracepath, tracepath6, ping, ping6 and arping."
SECTION = "console/network"
LICENSE ="BSD"
DEPENDS = "docbook-utils-native sgmlspl-native"

PR = "r4"

DEFAULT_PREFERENCE_angstrom = "2"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/i/iputils/iputils_${PV}.orig.tar.gz \
           file://debian/fix-dead-host-ping-stats.diff \
           file://debian/add-icmp-return-codes.diff \
           file://debian/use_gethostbyname2.diff \
           file://debian/fix-cmsghdr-offset-bug.diff \
           file://debian/cleanup-docbook-formatting.diff \
           file://debian/targets.diff \
           file://debian/fix-tracepath-docs.diff \
           file://debian/fix-arping-timeouts.diff \
           file://CVE-2010-2529.patch \
"

S = "${WORKDIR}/iputils_20071127.orig"

PACKAGES_IPV4 = "${PN}-ping ${PN}-arping ${PN}-tracepath"
PACKAGES_IPV6 = "${PN}-ping6 ${PN}-tracepath6 ${PN}-traceroute6"
all_pkgs = "${PACKAGES_IPV4} \
	${@base_contains('DISTRO_FEATURES', 'ipv6', '${PACKAGES_IPV6}', '', d)}"
PACKAGES += "${all_pkgs}"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_{PN} += "${all_pkgs}"

FILES_${PN}		= ""
FILES_${PN}-ping	= "${base_bindir}/ping.${PN}"
FILES_${PN}-ping6	= "${base_bindir}/ping6.${PN}"
FILES_${PN}-arping	= "${bindir}/arping"
FILES_${PN}-tracepath	= "${bindir}/tracepath"
FILES_${PN}-tracepath6	= "${bindir}/tracepath6"
FILES_${PN}-traceroute6	= "${bindir}/traceroute6"
FILES_${PN}-doc		= "${mandir}/man8"

do_compile () {
	make_targets="${@base_contains('DISTRO_FEATURES', 'ipv6', 'all', 'tracepath ping arping', d)}"
	oe_runmake 'CC=${CC}' \
		   KERNEL_INCLUDE="${STAGING_INCDIR}" \
		   LIBC_INCLUDE="${STAGING_INCDIR}" ${make_targets} man
}

do_install_ipv6 () {
	install -m 4555 ping6 ${D}${base_bindir}/ping6.${PN}
	install -m 4555 traceroute6 ${D}${bindir}/
	install -m 0755 tracepath6 ${D}${bindir}/
	install -m 0644 doc/traceroute6.8 ${D}${mandir}/man8/ || true
}
do_install () {
	install -m 0755 -d ${D}${base_bindir} ${D}${bindir} ${D}${mandir}/man8
	# SUID root programs
	install -m 4555 ping ${D}${base_bindir}/ping.${PN}
	# Other programs
	for i in arping tracepath; do
	  install -m 0755 $i ${D}${bindir}/
	done
	# Manual pages for things we build packages for
	for i in tracepath.8 ping.8 arping.8; do
	  install -m 0644 doc/$i ${D}${mandir}/man8/ || true
	done

	${@base_contains('DISTRO_FEATURES', 'ipv6', 'do_install_ipv6', '', d)}
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
