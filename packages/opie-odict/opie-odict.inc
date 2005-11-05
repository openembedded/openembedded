DESCRIPTION = "Dictionary look-up program"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "odict"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libodict.so* bin/odict apps/Applications/odict.desktop pics/odict/odict.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

