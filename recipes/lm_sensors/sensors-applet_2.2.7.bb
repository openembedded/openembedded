DESCRIPTION = "GNOME Sensors Applet is an applet for the GNOME Panel to display readings from hardware sensors"
LICENSE = "GPLv2"

inherit gnome

SRC_URI[md5sum] = "f342fab98be4f1b9a25af0689af20130"
SRC_URI[sha256sum] = "368bae3baf983e192a0751f89d563ab9052c3ab2ab28bf62002a0d78d1ffcefe"

DEPENDS += "gnome-panel libnotify"

SRC_URI = "${SOURCEFORGE_MIRROR}/sensors-applet/sensors-applet-${PV}.tar.gz"

EXTRA_OECONF = " --disable-scrollkeeper --with-libsensors=${STAGING_LIBDIR}/../ "

FILES_${PN}-dbg += "${libdir}/sensors-applet/plugins/.debug"

