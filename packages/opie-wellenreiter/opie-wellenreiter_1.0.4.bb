DESCRIPTION = "A Wireless Network Monitor"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RRECOMMENDS = "manufacturers"
APPNAME = "wellenreiter"
APPTYPE = "binary"
# 20050201 _is_ V1.0.4
CVSDATE = "20050201"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/wellenreiter \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/wellenreiter"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.* ${D}${palmtopdir}/pics/${APPNAME}/
}
