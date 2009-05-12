SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "glib-2.0 dbus-glib hotplug-dbus virtual/libx11"
RDEPENDS = "hotplug-dbus"

inherit gpe

SRC_URI = "${GPE_SVN} \
           file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

export CVSBUILD="no"

DEFAULT_PREFERENCE = "-1"
