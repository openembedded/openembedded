SECTION = "gpe"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus virtual/libx11"
RDEPENDS = "hotplug-dbus"
LICENSE = "GPL"

inherit gpe

SRC_URI += " file://dbus-new-api.patch;patch=1"
