DESCRIPTION = "User/Group manager for Opie"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "usermanager"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libusermanager.so* bin/usermanager apps/Settings/usermanager.desktop pics/usermanager/*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

