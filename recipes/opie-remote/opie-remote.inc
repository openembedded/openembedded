DESCRIPTION = "A remote control"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "lirc"
APPNAME = "remote"
APPTYPE = "binary"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/remote apps/Applications/remote.desktop pics/remote/*.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

