SECTION = "console/utils"
BROKEN = "1"
DEPENDS = "docbook-utils-native"
DESCRIPTION = "Utilities for the IP protocol."
LICENSE ="BSD"
SRC_URI = "http://www.tux.org/pub/people/alexey-kuznetsov/ip-routing/iputils-ss020927.tar.gz"
S = "${WORKDIR}/iputils"

EXTRA_OEMAKE = ""

do_compile () {
	oe_runmake 'CC=${CC}' \
		   KERNEL_INCLUDE="${STAGING_INCDIR}" \
		   LIBC_INCLUDE="${STAGING_INCDIR}"
	oe_runmake -C doc 'CC=${CC}' \
		   KERNEL_INCLUDE="${STAGING_INCDIR}" \
		   LIBC_INCLUDE="${STAGING_INCDIR}"
}

do_install () {
	install -d ${D}${base_bindir} ${D}${sbindir} \
		   ${D}${mandir}/man8 ${D}${docdir}/${P}
	install -m 0755 ping ${D}${base_bindir}/
	for f in ipg tracepath clockdiff rdisc arping \
		tftpd rarpd tracepath6 traceroute6 ping6; do
		install -m 0755 $f ${D}${sbindir}/
	done
	install -m 0644 doc/*.8 ${D}${mandir}/man8/
	install -m 0644 doc/*.html ${D}${docdir}/${P}/
}
