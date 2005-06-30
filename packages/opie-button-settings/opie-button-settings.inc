DESCRIPTION = "Device-buttons settings dialog"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-button-settings-pics"
APPNAME = "buttonsettings"


S = "${WORKDIR}/button"

inherit opie

# FILES plugins/application/libbuttonsettings.so* bin/buttonsettings apps/Settings/Button.desktop pics/buttonsettings/*.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/pics/devicebuttons/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/devicebuttons/*.png ${D}${palmtopdir}/pics/devicebuttons/
}

PACKAGES_prepend = "opie-button-settings-pics "
FILES_opie-button-settings-pics = "${palmtopdir}/pics/devicebuttons/z*" 
FILES_opie-button-settings-pics_h3600 = "${palmtopdir}/pics/devicebuttons/ipaq*"
PACKAGE_ARCH_h3600 = "h3600"
FILES_opie-button-settings-pics_h3900 = "${palmtopdir}/pics/devicebuttons/ipaq*"
PACKAGE_ARCH_h3900 = "h3900"
FILES_opie-button-settings-pics_simpad = "${palmtopdir}/pics/devicebuttons/simpad*"
PACKAGE_ARCH_simpad = "simpad"
