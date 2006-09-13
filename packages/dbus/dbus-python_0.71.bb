DEFAULT_PREFERENCE="-1"

SECTION = "devel/python"
PRIORITY = "optional"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "message bus system for applications to talk to one another - python bindings"
LICENSE = "GPL"
PR = "r0"
DEPENDS = "python-native"

SRC_URI = "http://freedesktop.org/software/dbus/releases/dbus-python-${PV}.tar.gz \
	   file://cross.patch;patch=1"

inherit distutils
