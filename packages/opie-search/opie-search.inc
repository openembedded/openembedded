DESCRIPTION = "Search through all PIM data"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "osearch"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libosearch.so* bin/osearch apps/1Pim/osearch.desktop pics/osearch/*.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

