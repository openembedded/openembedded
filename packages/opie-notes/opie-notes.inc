DESCRIPTION = "Notes"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
APPNAME = "opie-notes"
APPTYPE = "binary"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/notes \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/notes"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.* ${D}${palmtopdir}/pics/${APPNAME}/
}
