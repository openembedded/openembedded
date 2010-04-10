LICENSE = "GPL"
SECTION = "gpe"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus"
RDEPENDS = "hotplug-dbus"

inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "798085fd2e2b25f5145a05104d39ebc6"
SRC_URI[sha256sum] = "8ce9aee873a337f876f82d54eb10a258911a03b3abb4eb79f9b2f04c8c304bbb"
