DESCRIPTION = "Weather plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopiecore2 libopiepim2"
RDEPENDS = "opie-today"

APPNAME = "todayweatherplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/todayplugins/weather \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"

S = "${WORKDIR}/weather"

inherit opie

# FILES plugins/today/libtodayweatherplugin.so* pics/todayweatherplugin
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

