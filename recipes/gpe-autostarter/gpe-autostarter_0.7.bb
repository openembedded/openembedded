LICENSE = "GPL"
SECTION = "gpe"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus virtual/libx11"
RDEPENDS = "hotplug-dbus"

inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "f098c17601426c696f45c1b244fa1f73"
SRC_URI[sha256sum] = "094157f59ac1a5146953bc74e5dac9f4b28fa14545bc12df87899f61cdfe18d6"
