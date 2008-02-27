DESCRIPTION = "Linksys NSLU2 Stock Firmware Ramdisk."
PACKAGE_ARCH = "nslu2"
SECTION = "base"
PRIORITY = "required"
PR = "r3"

SRC_URI = "http://nslu.sf.net/downloads/nslu2-linksys-ramdisk-2.3r63-2.tar.bz2"

do_install () {
	( cd ${S} ; tar cvf - . ) | ( cd ${D} ; tar xvf - )
}

FILES_${PN} = "/"

COMPATIBLE_MACHINE = "nslu2"
