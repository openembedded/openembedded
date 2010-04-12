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

SRC_URI[md5sum] = "fbe22e4341f638234336a2f45053328d"
SRC_URI[sha256sum] = "7d107bd3f024d25d3552bfef30178e976a0ad6b26bd02f4a284bfe596ee33527"
