DESCRIPTION = "Configuration files for online package repositories aka feeds"

PR = "0"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FEED_BASEPATH ?= "unstable/feed/"

do_compile() {
        mkdir -p ${S}/${sysconfdir}/ipkg
	for feed in base debug perl python gstreamer ; do
          echo "src/gz ${feed} ${ANGSTROM_URI}/${FEED_BASEPATH}${FEED_ARCH}/${feed}" > ${S}/${sysconfdir}/ipkg/${feed}-feed.conf
	done

        echo "src/gz ${MACHINE_ARCH} ${ANGSTROM_URI}/${FEED_BASEPATH}${FEED_ARCH}/${MACHINE_ARCH}" >  ${S}/${sysconfdir}/ipkg/${MACHINE_ARCH}-feed.conf
	echo "src/gz no-arch ${ANGSTROM_URI}/${FEED_BASEPATH}/all" > ${S}/${sysconfdir}/ipkg/noarch-feed.conf
}


do_install () {
        install -d ${D}${sysconfdir}/ipkg
	install -m 0644  ${S}/${sysconfdir}/ipkg/* ${D}${sysconfdir}/ipkg/
}

