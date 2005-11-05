DESCRIPTION = "Utility for managing ssh-agent keys"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "ssh opie-sh-ssh-askpass"
APPNAME = "sshkeys"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/sshkeys apps/Settings/sshkeys.desktop pics/sshkeys/sshkeys.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

