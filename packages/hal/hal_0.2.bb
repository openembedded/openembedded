SECTION = "unknown"
DESCRIPTION = "Hardware Abstraction Layer"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "dbus expat"
RDEPENDS += "hotplug"
HOMEPAGE = "http://freedesktop.org/Software/hal"
LICENSE = "GPL LGPL AFL"

SRC_URI = "http://freedesktop.org/~david/hal-${PV}/hal-${PV}.tar.gz"
S = "${WORKDIR}/hal-${PV}"

inherit autotools

EXTRA_OECONF = "--with-hwdata=${datadir}/hwdata \
		--with-expat=${STAGING_LIBDIR}/.. \
		--with-dbus-sys=${sysconfdir}/dbus-1/system.d \
		--with-hotplug=${sysconfdir}/hotplug.d"
