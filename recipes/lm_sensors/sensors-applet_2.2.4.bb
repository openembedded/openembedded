DESCRIPTION = "GNOME Sensors Applet is an applet for the GNOME Panel to display readings from hardware sensors"
LICENSE = "GPLv2"

inherit gnome

DEPENDS += "gnome-panel libnotify"

SRC_URI = "${SOURCEFORGE_MIRROR}/sensors-applet/sensors-applet-${PV}.tar.gz"

EXTRA_OECONF = " --disable-scrollkeeper --with-libsensors=${STAGING_LIBDIR}/../ "

FILES_${PN}-dbg += "${libdir}/sensors-applet/plugins/"

