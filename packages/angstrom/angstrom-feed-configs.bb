DESCRIPTION = "Configuration files for online package repositories aka feeds"

#PV = "${DISTRO_VERSION}"
PR = "r6"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FEED_BASEPATH ?= "unstable/feed/"

IWMMXT_FEED = "${@base_contains('MACHINE_FEATURES', 'iwmmxt', 'iwmmxt', '',d)}"

do_compile() {
        mkdir -p ${S}/${sysconfdir}/opkg
	for feed in base debug perl python gstreamer ; do
          echo "src/gz ${feed} ${ANGSTROM_URI}/${FEED_BASEPATH}${FEED_ARCH}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
	done

        echo "src/gz ${MACHINE_ARCH} ${ANGSTROM_URI}/${FEED_BASEPATH}${FEED_ARCH}/machine/${MACHINE_ARCH}" >  ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
	echo "src/gz no-arch ${ANGSTROM_URI}/${FEED_BASEPATH}/all" > ${S}/${sysconfdir}/opkg/noarch-feed.conf
        
	# iwmmxt is a special case, add the iwmmxt feed for machine that have 'iwmmxt' in MACHINE_FEATURES
        if [ "${IWMMXT_FEED}" = "iwmmxt" ] ; then
	  echo "src/gz iwmmxt ${ANGSTROM_URI}/${FEED_BASEPATH}iwmmxt/base" > ${S}/${sysconfdir}/opkg/iwmmxt-feed.conf
	fi  
}


do_install () {
        install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

CONFFILES_${PN} += "${sysconfdir}/opkg/base-feed.conf \
                    ${sysconfdir}/opkg/debug-feed.conf \
                    ${sysconfdir}/opkg/perl-feed.conf \
                    ${sysconfdir}/opkg/python-feed.conf \
                    ${sysconfdir}/opkg/gstreamer-feed.conf \
                    ${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
                    ${sysconfdir}/opkg/noarch-feed.conf \
                   "

