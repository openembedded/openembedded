DESCRIPTION = "KeyZ Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "zkbapplet"
RDEPENDS = "opie-pics"
I18N_FILES = "keyz-cfg.ts"



S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/
        install -d ${D}${palmtopdir}/share/zkb/
        install -m 0644 ${WORKDIR}/share/zkb/*xml* ${D}${palmtopdir}/share/zkb/
	install -m 0644 ${WORKDIR}/share/zkb/zkb.xml.sample ${D}${palmtopdir}/share/zkb/zkb.xml
        install -d ${D}${palmtopdir}/bin
        install -m 0755 ${S}/keyz-cfg ${D}${palmtopdir}/bin/
        install -d ${D}${palmtopdir}/apps/Settings
        install -m 0644 ${WORKDIR}/apps/Settings/keyz-cfg.desktop ${D}${palmtopdir}/apps/Settings/
}
