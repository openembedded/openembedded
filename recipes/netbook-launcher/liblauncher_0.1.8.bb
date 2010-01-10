DESCRIPTION = "A library to build launchers"
LICENSE = "GPLv3,LGPLv2.1,LGPLv3"

DEPENDS = "glib-2.0 libwnck virtual/libx11 gconf gnome-menus"

SRC_URI = "http://launchpad.net/liblauncher/0.1/${PV}/+download/liblauncher-${PV}.tar.gz"

inherit autotools


