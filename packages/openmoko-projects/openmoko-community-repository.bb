DESCRIPTION = "Configuration files for online package repositories of Openmoko community repository feeds"
PR = "r0.03"

do_compile() {
    mkdir -p ${S}/${sysconfdir}/opkg
    for feed in Multiverse; do
        echo "src/gz daily-${feed} ${OPENMOKO_URI}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
    done
}
do_install () {
        install -d ${D}${sysconfdir}/opkg
        install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONFFILES_${PN} += "${sysconfdir}/opkg/Multiverse-feed.conf"

PKG_TAGS_${PN} = "group::repos alias::Om_Multiverse"

OPENMOKO_URI = "http://downloads.openmoko.org/repository"
