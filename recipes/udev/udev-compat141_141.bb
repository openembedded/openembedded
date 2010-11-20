# To use this package, you need:
# - udev main package with init script that supports udev-compat-wrapper
#   (enable per-platform in the udev.inc and udev*.bb files)
# - this package must be embedded into the image
#   (otherwise system will refuse to boot)
# - only one compat package is supported (pick the newest udev that
#   supports your oldest kernel and set is as
#   PREFERRED_PROVIDER_udev-compat in your machine config)
#
FILESPATHPKG =. "udev-${PV}:udev:"
require udev_141.bb
S = "${WORKDIR}/udev-${PV}"
DESCRIPTION = "udev compatibility helper package for systems that run old kernels"
PACKAGES = "${PN} ${PN}-dbg"
PROVIDES = "udev-compat"

# Need udev with udev-compat-wrapper support and nothing else.
RDEPENDS_${PN} = "udev-compat-wrapper"

# Remove hotplug RPROVIDES
RPROVIDES_${PN} = "udev-compat"

# We cannot use newer library: udev_monitor_new_from_netlink_compat() will fail.
# We cannot use older udev_monitor_new_from_netlink_compat(): Structures are incompatible.
# That is why we link udev statically with the old library.
export enable_shared = "no"
EXTRA_OECONF += "--enable-static"

# Remove everything except udevd and udevadm and rename these two.
do_install_append () {
	mv ${D}${base_sbindir}/udevd ${D}${base_sbindir}/udevd-compat
	mv ${D}${base_sbindir}/udevadm ${D}${base_sbindir}/udevadm-compat
	rm -rf ${D}${datadir} ${D}${base_libdir} ${D}${libdir} ${D}${includedir} ${D}${sysconfdir}
	rmdir ${D}${prefix} 2>/dev/null || true
}

# Remove udev init script installation.
INITSCRIPT_PACKAGES = ""
