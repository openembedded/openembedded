DESCRIPTION = "Notes"
SECTION = "opie/pim"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opie-notes"
APPTYPE = "binary"

S = "${WORKDIR}/notes"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.* ${D}${palmtopdir}/pics/${APPNAME}/
}
