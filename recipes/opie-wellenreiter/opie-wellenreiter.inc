DESCRIPTION = "A Wireless Network Monitor"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
RRECOMMENDS = "manufacturers"
APPNAME = "wellenreiter"
APPTYPE = "binary"

S = "${WORKDIR}/wellenreiter"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.* ${D}${palmtopdir}/pics/${APPNAME}/
}
