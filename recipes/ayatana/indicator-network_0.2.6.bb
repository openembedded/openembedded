DESCRIPTION = "Network Menu for controlling network connections. Uses Connection Manager."
LICENSE = "GPLv3"
SECTION = "x11/gnome"
DEPENDS = "gtk+ libindicator libdbusmenu libnotify ido indicator-applet"

inherit autotools

SRC_URI = "http://launchpad.net/indicator-network/trunk/0.2.6/+download/indicator-network-0.2.6.tar.gz"

# Fixed for wrong test in libtool without it I get this bogus error:
# arm-angstrom-linux-gnueabi-libtool: install: error: cannot install `libnetworkmenu.la' to a directory not ending in /usr/lib/indicators/3/
do_configure_append() {
        sed -i 's,func_fatal_error "error: cannot install,echo "bogus message about,' ${TARGET_PREFIX}libtool
}

FILES_${PN} += "${libdir}/indicators/3/* /usr/share/dbus-1/services/*"
FILES_${PN}-dbg += "${libdir}/indicators/3/.debug/"

SRC_URI[md5sum] = "a65d1b7e946ecdc6ba1ec4074ec83595"
SRC_URI[sha256sum] = "dfc0cd7a5add79d5b4d81ec443bb87647a8f895dd8d49fc2b288f74495e38d3f"
