DESCRIPTION = "A library to build launchers"
LICENSE = "GPLv3,LGPLv2.1,LGPLv3"

DEPENDS = "glib-2.0 libwnck virtual/libx11 gconf gnome-menus"

SRC_URI = "http://launchpad.net/liblauncher/0.1/${PV}/+download/liblauncher-${PV}.tar.gz"

inherit autotools



SRC_URI[md5sum] = "b220357aaccc581c05337d05c5a1356f"
SRC_URI[sha256sum] = "e2d7c0eb9702e83e28551b89e3cbc283c6835e42c8336bd251c3b5c50dfdc9e5"
