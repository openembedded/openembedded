DESCRIPTION = "Stock ticker plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-today libqtaux2"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "todaystocktickerplugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/todayplugins/stockticker \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/stockticker"

inherit opie

# FILES plugins/today/libtodaystocktickerplugin.so* bin/stockticker pics/stockticker/stockticker.png
do_install() {
        install -d ${D}${palmtopdir}/pics/stockticker/
        install -m 0644 ${WORKDIR}/pics/stockticker/*.png ${D}${palmtopdir}/pics/stockticker/
}

