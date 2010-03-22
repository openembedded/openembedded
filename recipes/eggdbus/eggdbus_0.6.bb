DESCRIPTION = "gobject dbus binding"
HOMEPAGE = "http://cgit.freedesktop.org/~david/eggdbus"
LICENSE = "GPLv2"

DEPENDS = "dbus glib-2.0 dbus-glib eggdbus-native"
DEPENDS_virtclass-native = "dbus-native glib-2.0-native dbus-glib-native"

SRC_URI[eggdbus.md5sum] = "0a111faa54dfba2cf432c2c8e8a76e06"
SRC_URI[eggdbus.sha256sum] = "3ad26e271c1a879bafcd181e065fe0ed53b542299a773c3188c9edb25b895ed1"

BASE_SRC_URI = "http://cgit.freedesktop.org/~david/${BPN}/snapshot/${BPN}-${PV}.tar.bz2;name=eggdbus \
          file://gtk-doc.patch;patch=1 \
          "

SRC_URI = "${BASE_SRC_URI} \
           file://marshal.patch;patch=1 \
          "

SRC_URI_virtclass-native = "${BASE_SRC_URI}"

inherit autotools

EXTRA_OECONF = " --disable-man-pages --disable-gtk-doc-html "

BBCLASSEXTEND = "native"

PARALLEL_MAKE = ""
