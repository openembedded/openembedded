LICENSE = "GPL"
SECTION = "gpe"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus virtual/libx11"
RDEPENDS = "hotplug-dbus"

inherit gpe

SRC_URI += "file://wireless.patch;patch=1 \
	    file://makefile-fix.patch;patch=1"


SRC_URI[md5sum] = "254a580e67d8e804adb3583281ae8586"
SRC_URI[sha256sum] = "532e1b0122c845295987deddf72ebbfd3c319f6b714f033f5daa74f068acb1f2"
