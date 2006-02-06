SECTION = "gpe"
DEPENDS = "glib-2.0 dbus hotplug-dbus x11"
RDEPENDS = "hotplug-dbus"
LICENSE = "GPL"
PR = "r2"

inherit gpe
	
#SRC_URI += " file://dbus-new-api.patch;patch=1"
