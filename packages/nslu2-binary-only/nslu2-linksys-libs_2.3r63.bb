DESCRIPTION = "Linksys NSLU2 Stock Firmware Libraries."
PACKAGE_ARCH = "nslu2"
SECTION = "base"
PRIORITY = "required"
PR = "r3"

SRC_URI = "http://nslu.sf.net/downloads/nslu2-linksys-ramdisk-2.3r63-2.tar.bz2"

S = "${WORKDIR}/nslu2-linksys-ramdisk-2.3r63"

do_install () {
	( cd ${S} ; rm -rf bin dev etc home lost+found mnt proc sbin share tmp upload usr var )
	( cd ${S} ; tar cvf - . ) | ( cd ${D} ; tar xvf - )
}

FILES_${PN} = "/lib"

COMPATIBLE_MACHINE = "nslu2"
