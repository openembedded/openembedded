DESCRIPTION = "Opie Bluetooth Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopietooth1"
APPNAME = "bluetoothapplet"

S = "${WORKDIR}/applet"

EXTRA_QMAKEVARS_POST += " INCLUDEPATH+=${STAGING_INCDIR}/opietooth "

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/bluetoothapplet
	install -m 0644 ${WORKDIR}/bluetoothapplet/*.png ${D}${palmtopdir}/pics/bluetoothapplet
}

