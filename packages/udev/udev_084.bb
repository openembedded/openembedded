DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.12."
RPROVIDES = "hotplug"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://udevsynthesize.patch;patch=1 \
	   file://udevsynthesize.sh \
	   file://mount.blacklist \
	   file://input.sh \
	   file://udev_network_queue.sh"

include udev.inc

INITSCRIPT_PARAMS = "start 03 S . start 55 0 6 ."

PR = "r15"

FILES_${PN} += "${base_libdir}"
UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/ extras/run_directory/"
EXTRA_OEMAKE += "libudevdir=/lib/udev"
PACKAGE_ARCH = "${MACHINE}"

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev
	install -m 0755 ${WORKDIR}/udev_network_queue.sh ${D}${sysconfdir}/init.d/

	install -d ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/
	install -m 0644 ${WORKDIR}/local.rules         ${D}${sysconfdir}/udev/rules.d/local.rules
	install -m 0644 ${WORKDIR}/permissions.rules   ${D}${sysconfdir}/udev/rules.d/permissions.rules
	install -m 0644 ${WORKDIR}/udev.rules          ${D}${sysconfdir}/udev/rules.d/udev.rules
	install -m 0644 ${WORKDIR}/links.conf          ${D}${sysconfdir}/udev/links.conf
	if [ "${UDEV_DEVFS_RULES}" = "1" ]; then
		install -m 0644 ${WORKDIR}/devfs-udev.rules ${D}${sysconfdir}/udev/rules.d/devfs-udev.rules
	fi

	install -d ${D}${sysconfdir}/udev/scripts/

	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts
	install -m 0755 ${WORKDIR}/input.sh ${D}${sysconfdir}/udev/scripts

	install -d ${D}${base_libdir}/udev/
	install -m 0755 ${S}/udevsynthesize ${D}${base_libdir}/udev/udevsynthesize
	install -m 0755 ${WORKDIR}/udevsynthesize.sh ${D}${sbindir}/udevsynthesize
}


pkg_postinst_append() {
	update-rc.d -s udev_network_queue.sh start 41 S . start 55 0 6 .
	
	# Add the root partition to mount.blacklist to avoid a bug in the auto-mounter,
	# causing confusion with fsck on boot
	
        while read dev mp fs junk
        do
                if test "$mp" = "/"
                then
                        root_partition="$dev"
                        echo "$root_partition" >> /etc/udev/mount.blacklist
                fi
        done < /etc/fstab
	
}


pkg_postrm_append() {
	update-rc.d -f udev_network_queue.sh remove
}
