LICENSE = "makedev"
PR = "r1"
SECTION = "base"
DESCRIPTION = "The MAKEDEV executable is used to create \
device files, often in /dev."

SRC_URI = "${DEBIAN_MIRROR}/main/m/makedev/makedev_${PV}.orig.tar.gz"
S = "${WORKDIR}/makedev-${PV}.orig"

do_install () {
	install -d ${D}/dev ${D}${mandir}/man8
	install -m 0755 MAKEDEV ${D}/dev/MAKEDEV
	install -m 0644 MAKEDEV.man ${D}${mandir}/man8/MAKEDEV.8
}

FILES_${PN} = "/dev"
