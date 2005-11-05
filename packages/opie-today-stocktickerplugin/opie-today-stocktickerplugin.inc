DESCRIPTION = "Stock ticker plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-today libqtaux2"
APPNAME = "todaystocktickerplugin"


S = "${WORKDIR}/stockticker"

inherit opie

# FILES plugins/today/libtodaystocktickerplugin.so* bin/stockticker pics/stockticker/stockticker.png
do_install() {
        install -d ${D}${palmtopdir}/pics/stockticker/
        install -m 0644 ${WORKDIR}/pics/stockticker/*.png ${D}${palmtopdir}/pics/stockticker/
}

