DESCRIPTION = "udev is a program which dynamically creates and removes device nodes from \
/dev/. It responds to /sbin/hotplug device events and requires a 2.6 kernel."
LICENSE = "GPL"

PACKAGES =+ "udev-utils"
FILES_udev-utils = "${usrbindir}/udevinfo ${usrbindir}/udevtest"

inherit update-rc.d

INITSCRIPT_NAME = "udev"
INITSCRIPT_PARAMS = "start 03 S ."

export HOSTCC = "${BUILD_CC}"
export udevdir ?= "/dev"
export usrbindir := "${bindir}"
export usrsbindir := "${sbindir}"
export etcdir = "${sysconfdir}"
LD = "${CC}"
bindir = "/bin"
sbindir = "/sbin"

UDEV_EXTRAS = "extras/scsi_id/ extras/volume_id/"
FILES_${PN} += "${usrbindir} ${usrsbindir}"
EXTRA_OEMAKE = "-e \
		'EXTRAS=${UDEV_EXTRAS}' \
		'STRIP=echo'"

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev
}
