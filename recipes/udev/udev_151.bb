DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.12."
LICENSE = "GPL"

PR = "r3"

# Untested
DEFAULT_PREFERENCE = "-1"

# Needed for udev-extras
DEPENDS = "gperf-native usbutils acl glib-2.0"

# needed for init.d script
RDEPENDS_${PN} += "udev-utils"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://mount.blacklist \
	   file://run.rules \
	   "
SRC_URI += " \
       file://udev.rules \
       file://devfs-udev.rules \
       file://links.conf \
       file://permissions.rules \
       file://mount.sh \
       file://network.sh \
       file://local.rules \
       file://default \
       file://init \
       file://cache \
"

SRC_URI_append_h2200 = " file://50-hostap_cs.rules "
PACKAGE_ARCH_h2200 = "h2200"

#buglabs's bug device
SRC_URI_append_bug = " \
       file://30-BUG.rules \
       file://10-mx31.rules \
       file://bmi_eventpipe.sh "

PACKAGE_ARCH_bug = "bug"

inherit update-rc.d autotools

EXTRA_OECONF += " --with-udev-prefix= \
                  --with-libdir-name=${base_libdir} \
                  --disable-introspection \
                  ac_cv_file__usr_share_pci_ids=yes \
                  ac_cv_file__usr_share_hwdata_pci_ids=no \
                  ac_cv_file__usr_share_misc_pci_ids=no \
                  --sbindir=${base_sbindir} \
"

INITSCRIPT_NAME = "udev"
INITSCRIPT_PARAMS = "start 03 S ."

PACKAGES =+ "libudev libgudev udev-utils"

FILES_libudev = "${libdir}/libudev.so.*"
FILES_libgudev = "${libdir}/libgudev*.so.*"

FILES_udev-utils = "${bindir}/udevinfo ${base_sbindir}/udevadm ${bindir}/udevtest"

RPROVIDES_${PN} = "hotplug"
FILES_${PN} += "${usrbindir}/* ${usrsbindir}/udevd"
FILES_${PN}-dbg += "${usrbindir}/.debug ${usrsbindir}/.debug"

# udev installs binaries under $(udev_prefix)/lib/udev, even if ${libdir}
# is ${prefix}/lib64
FILES_${PN} += "/lib/udev/* ${libdir}/ConsoleKit"
FILES_${PN}-dbg += "/lib/udev/.debug"

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev
	install -m 0755 ${WORKDIR}/cache ${D}${sysconfdir}/init.d/udev-cache

	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default ${D}${sysconfdir}/default/udev

 	cp ${S}/rules/rules.d/* ${D}${sysconfdir}/udev/rules.d/
	cp ${S}/rules/packages/* ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/
	install -m 0644 ${WORKDIR}/local.rules         ${D}${sysconfdir}/udev/rules.d/local.rules
	install -m 0644 ${WORKDIR}/permissions.rules   ${D}${sysconfdir}/udev/rules.d/permissions.rules
	install -m 0644 ${WORKDIR}/run.rules          ${D}${sysconfdir}/udev/rules.d/run.rules
	install -m 0644 ${WORKDIR}/udev.rules          ${D}${sysconfdir}/udev/rules.d/udev.rules
	install -m 0644 ${WORKDIR}/links.conf          ${D}${sysconfdir}/udev/links.conf
	if [ "${UDEV_DEVFS_RULES}" = "1" ]; then
		install -m 0644 ${WORKDIR}/devfs-udev.rules ${D}${sysconfdir}/udev/rules.d/devfs-udev.rules
	fi

	touch ${D}${sysconfdir}/udev/saved.uname
	touch ${D}${sysconfdir}/udev/saved.cmdline
	touch ${D}${sysconfdir}/udev/saved.atags

	install -d ${D}${sysconfdir}/udev/scripts/

	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts
}

do_install_append_h2200() {
	install -m 0644 ${WORKDIR}/50-hostap_cs.rules         ${D}${sysconfdir}/udev/rules.d/50-hostap_cs.rules
}

do_install_append_bug() {
	install -m 0644 ${WORKDIR}/30-BUG.rules ${D}${sysconfdir}/udev/rules.d/30-BUG.rules
	install -m 0644 ${WORKDIR}/10-mx31.rules ${D}${sysconfdir}/udev/rules.d/10-mx31.rules
	install -m 0644 ${WORKDIR}/bmi_eventpipe.sh ${D}${sysconfdir}/udev/scripts/bmi_eventpipe.sh
}

# Create the cache after checkroot has run
pkg_postinst_${PN}_append() {
	update-rc.d $OPT udev-cache start 12 S .
}

