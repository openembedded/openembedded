DESCRIPTION = "Security settings dialog for the Opie environment."
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RRECOMMENDS = "opie-securityplugin-pin"
PR = "r2"

APPNAME = "security"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/settings/security \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libsecurity.so* bin/security apps/Settings/Security.desktop pics/security
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/

	for icon in Security.png lock.png multiauth.png sync.png users.png;
	do
	    install -m 0644 ${WORKDIR}/pics/${APPNAME}/$icon ${D}${palmtopdir}/pics/${APPNAME}/
	done
}

