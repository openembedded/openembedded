DESCRIPTION = "GNOME Sensors Applet is an applet for the GNOME Panel to display readings from hardware sensors"
LICENSE = "GPLv2"

inherit gnome

DEPENDS += "gnome-panel libnotify"

SRC_URI = "${SOURCEFORGE_MIRROR}/sensors-applet/sensors-applet-${PV}.tar.gz"

EXTRA_OECONF = " --disable-scrollkeeper --with-libsensors=${STAGING_LIBDIR}/../ " 

FILES_${PN}-dbg += "${libdir}/sensors-applet/plugins/"


SRC_URI[md5sum] = "4ba94415125db147efcc1ae76f9703ee"
SRC_URI[sha256sum] = "6be95f70458d299f28bfc81dee201b3e1c328bc55df00fc7f2c30d7f8f6faba0"
