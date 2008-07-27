DESCRIPTION = "Configuration files for online package repositories aka feeds"
PR = "r0"

do_compile() {
    mkdir -p ${S}/${sysconfdir}/opkg
    for feed in all armv4t neo1973 ${MACHINE_ARCH}; do
        echo "src/gz fso-${feed} ${FEED_URI}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
    done
}
do_install () {
        install -d ${D}${sysconfdir}/opkg
        install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONFFILES_${PN} += "\
  ${sysconfdir}/opkg/all-feed.conf \
  ${sysconfdir}/opkg/armv4t-feed.conf \
  ${sysconfdir}/opkg/neo1973-feed.conf \
  ${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
"

FEED_URI = "http://buildhost.freesmartphone.org/~mickeyl/deploy-om-gta02/ipk"
