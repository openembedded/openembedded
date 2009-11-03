require avahi.inc

PR = "r1"

# FIXME: without --enable-gtk, avahi-discover (pygtk) won't be built
FILES_avahi-discover = ""

PROVIDES = "avahi"
DEPENDS += "python-native"

SRC_URI += "file://configure-check-pymod.patch;patch=1"

S = "${WORKDIR}/avahi-${PV}"

RDEPENDS_avahi-discover = "python-avahi python-pygtk"
RDEPENDS_python-avahi = "python-dbus"
PACKAGES =+ "python-avahi"

AVAHI_PYTHON = "--enable-python"
