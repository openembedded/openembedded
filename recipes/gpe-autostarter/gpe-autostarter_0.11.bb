SECTION = "gpe"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus virtual/libx11"
RDEPENDS = "hotplug-dbus"
LICENSE = "GPL"

inherit gpe

SRC_URI += "file://dbus-new-api.patch;patch=1 \
	    file://makefile-fix.patch;patch=1"


SRC_URI[md5sum] = "d993818295e00754592ee6c13db4a723"
SRC_URI[sha256sum] = "702c3336d96fb49678c1b0a95e16c76e398c63f58c947df6ba275e9cacad4629"
