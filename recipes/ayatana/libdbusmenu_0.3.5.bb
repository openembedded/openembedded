DESCRIPTION = "Ayatana dbus indicator helper library"
LICENSE = "GPLv3"
DEPENDS = "json-glib dbus"

inherit autotools
SRC_URI = "http://launchpad.net/dbusmenu/0.3/0.3.5/+download/libdbusmenu-${PV}.tar.gz"

SRC_URI[md5sum] = "e71d1d29d182304d5c381ae0add0e9ae"
SRC_URI[sha256sum] = "a6f267ff28a54dfd2814cb9b4fb3bf3eb07f523c65f001f12d3446e01b7b231f"
