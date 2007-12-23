require hal.inc

DEPENDS = "virtual/kernel dbus-glib udev intltool intltool-native expat libusb"
RDEPENDS += "udev hal-info"
#RDEPENDS_hal-device-manager = "python hal python-pygnome"
RRECOMMENDS = "udev-utils"

PR = "r3"

SRC_URI += "file://99_hal \
            file://20hal \
	   "

# machines with pci and acpi get a machine dependant hal
EXTRA_OECONF = "--with-hwdata=${datadir}/hwdata \
                --with-expat=${STAGING_LIBDIR}/.. \
                --with-dbus-sys=${sysconfdir}/dbus-1/system.d \
                --with-hotplug=${sysconfdir}/hotplug.d \
                --disable-docbook-docs \
                --disable-policy-kit \
                --disable-pmu \
                --disable-pnp-ids \
                ${@base_contains('COMBINED_FEATURES', 'pci', '--enable-pci --enable-pci-ids', '--disable-pci --disable-pci-ids',d)} \
                ${@base_contains('MACHINE_FEATURES', 'acpi', '--enable-acpi', '--disable-acpi',d)} \
               "

MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('MACHINE_FEATURES', 'acpi', '${MACHINE_ARCH}', '${MY_ARCH}',d)}"
PACKAGE_ARCH = "${@base_contains('MACHINE_FEATURES', 'pci', '${MACHINE_ARCH}', '${MY_ARCH}',d)}"

do_install_append() {
	install -d ${D}/etc/default/volatiles
	install -m 0644 ${WORKDIR}/99_hal ${D}/etc/default/volatiles
        install -d ${D}/etc/dbus-1/event.d
        install -m 0755 ${WORKDIR}/20hal ${D}/etc/dbus-1/event.d
}

do_stage() {
        autotools_stage_all
        install -d ${STAGING_LIBDIR}
        install -m 755 libhal/.libs/libhal.so.1.0.0 ${STAGING_LIBDIR}/libhal.so
        install -m 755 libhal-storage/.libs/libhal-storage.so.1.0.0 ${STAGING_LIBDIR}/libhal-storage.so
}

# At the time the postinst runs, dbus might not be setup so only restart if running
pkg_postinst_hal () {
	# can't do this offline
	if [ "x$D" != "x" ]; then
		exit 1
	fi

	/etc/init.d/populate-volatile.sh update

	grep haldaemon /etc/group || addgroup haldaemon
	grep haldaemon /etc/passwd || adduser --disabled-password --system --home /var/run/hald --no-create-home haldaemon --ingroup haldaemon -g HAL

	DBUSPID=`pidof dbus-daemon`

	if [ "x$DBUSPID" != "x" ]; then
		/etc/init.d/dbus-1 force-reload
	fi
}

pkg_postrm_hal () {
	deluser haldaemon || true
	delgroup haldaemon || true
}

#PACKAGES += "hal-device-manager"

#FILES_hal-device-manager = " \
#               ${datadir}/hal/device-manager/ \
#               ${bindir}/hal-device-manager"

FILES_${PN} = "${sysconfdir} \
                ${bindir}/lshal \
                ${bindir}/hal-find-by-capability \
                ${bindir}/hal-find-by-property \
                ${bindir}/hal-device  \
                ${bindir}/hal-get-property \
                ${bindir}/hal-set-property  \
                ${bindir}/hal-lock  \
                ${bindir}/hal-is-caller-locked-out  \
                ${sbindir} \
                ${libdir}/libhal.so.* \
                ${libdir}/libhal-storage.so.* \
                ${libdir}/hal \
                ${libexecdir} \
                ${datadir}/hal/fdi \
                ${datadir}/hal/scripts"
