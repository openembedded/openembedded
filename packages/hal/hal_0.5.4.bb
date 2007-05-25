require hal.inc

DEPENDS = "dbus expat libusb"
RDEPENDS += "hotplug"
RDEPENDS_hal-device-manager = "python hal python-pygnome"
RRECOMMENDS = "udev-utils"
PR = "r1"

EXTRA_OECONF = "--with-hwdata=${datadir}/hwdata \
		--with-expat=${STAGING_LIBDIR}/.. \
		--with-dbus-sys=${sysconfdir}/dbus-1/system.d \
		--with-hotplug=${sysconfdir}/hotplug.d \
		--disable-docbook-docs"

do_stage() {
	autotools_stage_includes
	install -d ${STAGING_LIBDIR}
	install -m 755 libhal/.libs/libhal.so.1.0.0 ${STAGING_LIBDIR}/libhal.so
	install -m 755 libhal-storage/.libs/libhal-storage.so.1.0.0 ${STAGING_LIBDIR}/libhal-storage.so
}

PACKAGES += "hal-device-manager"
FILES_${PN} = "${sysconfdir} ${bindir}/lshal ${bindir}/hal-get-property ${bindir}/hal-set-property  ${sbindir} ${libdir}/libhal.so* ${libdir}/libhal-storage.so* ${libexecdir} ${datadir}/hal/fdi"
FILES_hal-device-manager = "${datadir}/hal/device-manager/ ${bindir}/hal-device-manager"

