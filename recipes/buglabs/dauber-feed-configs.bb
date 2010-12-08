DESCRIPTION = "Configuration files for online package repositories aka feeds"

PR = "r1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FEED_BASEPATH = "buildbot/trunk/incremental/feeds/"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg

	for feed in all armv7a bug20 ; do
		  echo "src/gz dauber-${feed} http://dauber/${FEED_BASEPATH}${feed}" > ${S}/${sysconfdir}/opkg/dauber-${feed}-feed.conf
	done
}


do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES_${PN} = "${sysconfdir}/opkg/"

CONFFILES_${PN} += "${sysconfdir}/opkg/*.conf"
