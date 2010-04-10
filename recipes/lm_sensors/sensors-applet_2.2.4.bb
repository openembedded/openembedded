DESCRIPTION = "GNOME Sensors Applet is an applet for the GNOME Panel to display readings from hardware sensors"
LICENSE = "GPLv2"

inherit gnome

DEPENDS += "gnome-panel libnotify"

SRC_URI = "${SOURCEFORGE_MIRROR}/sensors-applet/sensors-applet-${PV}.tar.gz"

EXTRA_OECONF = " --disable-scrollkeeper --with-libsensors=${STAGING_LIBDIR}/../ "

FILES_${PN}-dbg += "${libdir}/sensors-applet/plugins/"


SRC_URI[md5sum] = "778f637524a90a9b6475ab77b0e90dd9"
SRC_URI[sha256sum] = "a52214f2cf2b23a49394804dc589be51eecd4b8674f141047a46a550882f28f6"
