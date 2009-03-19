DESCRIPTION = "DocTab settings dialog for the Opie environment."
SECTION = "opie/settings"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "doctab"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libdoctab.so* bin/doctab apps/Settings/DocTab.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

