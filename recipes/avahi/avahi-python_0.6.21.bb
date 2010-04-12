require avahi.inc

PR = "r8"

# FIXME: without --enable-gtk, avahi-discover (pygtk) won't be built
FILES_avahi-discover = ""

PROVIDES = "avahi"
DEPENDS += "python-native"

SRC_URI += "file://dbus-pre-1.1.1-support.patch;patch=1 \
            file://configure-check-pymod.patch;patch=1"
S = "${WORKDIR}/avahi-${PV}"

RDEPENDS_avahi-discover = "python-avahi python-pygtk"
RDEPENDS_python-avahi = "python-dbus"
PACKAGES =+ "python-avahi"

AVAHI_PYTHON = "--enable-python"

SRC_URI[md5sum] = "9cc68f79c50c9dd9e419990c3c9b05b9"
SRC_URI[sha256sum] = "d817c35f43011861476eab02eea14edd123b2bc58b4408d9d9b69b0c39252561"
