DESCRIPTION = "Opie Sheet"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "opie-sheet"


S = "${WORKDIR}/opie-sheet"

inherit opie

# FILES plugins/application/libsheetqt.so* bin/sheetqt apps/Applications/opie-sheet.desktop help/en/html/sheetqt.html pics/opie-sheet/*.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

