DESCRIPTION = "Opie Bluetooth Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopietooth1"

APPNAME = "bluetoothapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opietooth/applet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics/bluetoothapplet"
S = "${WORKDIR}/applet"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/bluetoothapplet
	install -m 0644 ${WORKDIR}/bluetoothapplet/*.png ${D}${palmtopdir}/pics/bluetoothapplet
}

