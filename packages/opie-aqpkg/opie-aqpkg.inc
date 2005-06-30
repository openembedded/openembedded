DESCRIPTION = "A Package Manager"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "aqpkg"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libaqpkg.so* bin/aqpkg pics/aqpkg apps/Settings/aqpkg.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

