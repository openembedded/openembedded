DESCRIPTION = "Ayatana indicators project library"
LICENSE = "GPLv3"
SECTION = "x11/gnome"
DEPENDS = "gtk+ dbus-glib libdbusmenu"

# We need C99 for round()
CFLAGS += "--std=c99"

inherit autotools
SRC_URI = "http://launchpad.net/libindicator/0.3/0.3.8/+download/libindicator-${PV}.tar.gz"

SRC_URI[md5sum] = "4262524fc851613225c4fb81ff9871a7"
SRC_URI[sha256sum] = "b16b1b71cb6c4e310156832b48d9acc878108ba771bdbe3f879c69e4a29ca0a4"
