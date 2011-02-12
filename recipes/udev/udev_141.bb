DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.12."

# Untested
DEFAULT_PREFERENCE = "-1"

require udev.inc

PR = "${INC_PR}.6"

SRC_URI += "file://mount.blacklist \
	    file://run.rules \
	    file://default \
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

EXTRA_OECONF += " --with-udev-prefix= \
                  --with-libdir-name=${base_libdir} \
"

UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/"

LEAD_SONAME = "libudev.so.0"

RPROVIDES_${PN} = "hotplug"
FILES_${PN} += "${usrbindir}/* ${usrsbindir}/udevd ${sbindir}/udevadm"
FILES_${PN}-dbg += "${usrbindir}/.debug ${usrsbindir}/.debug"

# udev installs binaries under $(udev_prefix)/lib/udev, even if ${libdir}
# is ${prefix}/lib64
FILES_${PN} += "/lib/udev/* /lib/udev/*"
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

	# Move udev rules from $(udev_prefix)/lib to /etc.
	# This is hardcoded to $(udev_prefix)/lib/udev/rules.d in the
	# Makefile, even if libdir is lib64.
	mv ${D}/lib/udev/rules.d ${D}${sysconfdir}/udev/

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
	touch ${D}${sysconfdir}/udev/saved.devices
	touch ${D}${sysconfdir}/udev/saved.atags

	install -d ${D}${sysconfdir}/udev/scripts/

	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts
        oe_libinstall -C udev/lib libudev ${D}${libdir}
        install ${S}/udev/lib/libudev.h ${D}${includedir}
}

do_install_append_h2200() {
	install -m 0644 ${WORKDIR}/50-hostap_cs.rules         ${D}${sysconfdir}/udev/rules.d/50-hostap_cs.rules
}

do_install_append_bug() {
	install -m 0644 ${WORKDIR}/30-BUG.rules ${D}${sysconfdir}/udev/rules.d/30-BUG.rules
	install -m 0644 ${WORKDIR}/10-mx31.rules ${D}${sysconfdir}/udev/rules.d/10-mx31.rules
	install -m 0644 ${WORKDIR}/bmi_eventpipe.sh ${D}${sysconfdir}/udev/scripts/bmi_eventpipe.sh
}

do_install_append_hipox() {
	# we don't like persistent net if rules at hipox machine
	rm -f ${D}${sysconfdir}/udev/rules.d/75-persistent-net-generator.rules
}

# Create the cache after checkroot has run
pkg_postinst_udev_append() {
if test "x$D" != "x"; then
	OPT="-r $D"
else
	OPT="-s"
fi
update-rc.d $OPT udev-cache start 12 S .

if [ -e $D/lib/udev/rules.d ] && [ ! -L $D/lib/udev/rules.d ] ; then
	echo "$D/lib/udev/rules.d is not a symlink, fixing that"
	mv $D/lib/udev/rules.d/* $D${sysconfdir}/udev/rules.d/
	rm -rf $D/lib/udev/rules.d
	ln -sf ${sysconfdir}/udev/rules.d $D/lib/udev/
fi
}

SRC_URI[md5sum] = "86382b7bbc64459e714c65a2a4e10916"
SRC_URI[sha256sum] = "001be4a8963c48e7debc82c6078562d087a2979da63e558a5e3613c03725c377"
