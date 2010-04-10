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

SRC_URI[md5sum] = "a83155a6e29e3988f07e5eea3287b21e"
SRC_URI[sha256sum] = "9220d974f5515b8ccfa3900cd72cedcac0fa4cc87ca3c64405f7c55346cbba59"
