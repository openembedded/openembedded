LICENSE = "GPL"
SECTION = "gpe"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus virtual/libx11"
RDEPENDS = "hotplug-dbus"

inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"
