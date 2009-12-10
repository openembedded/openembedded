DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.12."
RPROVIDES_${PN} = "hotplug"

PR = "r6"

DEFAULT_PREFERENCE = "-118"

SRC_URI = "\
 http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
 file://flags.patch;patch=1 \
 file://vol_id_ld.patch;patch=1 \
 file://udevtrigger_add_devname_filtering.patch;patch=1 \
 file://mtd-exclude-persistent.patch;patch=1 \
 file://mount.blacklist \
"
TARGET_CC_ARCH += "${LDFLAGS}"

require udev.inc

INITSCRIPT_PARAMS = "start 03 S ."

FILES_${PN} += "${base_libdir}/udev/*"
FILES_${PN}-dbg += "${base_libdir}/udev/.debug"
UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/"
EXTRA_OEMAKE += "libudevdir=/lib/udev libdir=${base_libdir} prefix="

do_compile_prepend() {
	sed -i s,asmlinkage,, *.c
}

do_install () {
	install -d ${D}${usrsbindir} \
                   ${D}${sysconfdir} \
                   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev

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

	install -d ${D}${base_libdir}/udev/
}

pkg_postinst_append() {

       # Add the root partition to mount.blacklist to avoid a bug in the auto-mounter,
       # causing confusion with fsck on boot

        while read dev mp fs junk
        do
                if test "$mp" = "/"
                then
                        root_partition="$dev"
                        echo "$root_partition" >> $D${sysconfdir}/udev/mount.blacklist
                fi
        done < $D${sysconfdir}/fstab
}

