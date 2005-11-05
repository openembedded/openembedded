SECTION = "console/network"
DESCRIPTION = "ifplugd is a Linux daemon which will automatically configure your ethernet device when a cable is plugged in and automatically unconfigure it if the cable is pulled."
HOMEPAGE = "http://0pointer.de/lennart/projects/ifplugd/"
DEPENDS = "libdaemon"
LICENSE = "GPL"

SRC_URI = "http://0pointer.de/lennart/projects/ifplugd/ifplugd-${PV}.tar.gz"

inherit autotools update-rc.d pkgconfig

EXTRA_OECONF = "--disable-lynx"

INITSCRIPT_NAME = "ifplugd"
INITSCRIPT_PARAMS = "defaults"

CONFFILES_${PN}_nylon = "${sysconfdir}/ifplugd/ifplugd.conf"
