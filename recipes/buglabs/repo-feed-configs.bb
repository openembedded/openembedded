DESCRIPTION = "Configuration files for public online package repositories aka feeds."
HOMEPAGE="http://repo.buglabs.net/"
PR = "r1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FEED_BASEPATH = "2.0/"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg

	for feed in all armv7a bug20 ; do
		  echo "src/gz repo-${feed} http://repo.buglabs.net/${FEED_BASEPATH}${feed}" > ${S}/${sysconfdir}/opkg/repo-${feed}-feed.conf
	done
}


do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES_${PN} = "${sysconfdir}/opkg/"

CONFFILES_${PN} += "${sysconfdir}/opkg/*.conf"
