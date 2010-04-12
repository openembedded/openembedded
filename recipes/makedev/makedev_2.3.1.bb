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

SRC_URI[md5sum] = "89c4b6b4a89f6502626783716fc7d887"
SRC_URI[sha256sum] = "8599712f2b2b3778eea344f59e1512cea284e802560317fac436585885a41dfa"
