DESCRIPTION = "Opie Time-zone / world clock settings"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
RRECOMMENDS = "tzdata"
PR = "r1"

APPNAME = "citytime"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

