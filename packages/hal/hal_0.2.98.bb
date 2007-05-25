require hal.inc

DEPENDS = "dbus expat"
RDEPENDS += "hotplug"

EXTRA_OECONF = "--with-hwdata=${datadir}/hwdata \
		--with-expat=${STAGING_LIBDIR}/.. \
		--with-dbus-sys=${sysconfdir}/dbus-1/system.d \
		--with-hotplug=${sysconfdir}/hotplug.d"
