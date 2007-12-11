DESCRIPTION = "Message bus system for applications to talk to one another - python bindings"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "GPL"
SECTION = "devel/python"
DEPENDS = "python-pyrex-native dbus dbus-glib"
PR = "r0"

SRC_URI = "http://freedesktop.org/software/dbus/releases/dbus-python-${PV}.tar.gz"

inherit distutils
