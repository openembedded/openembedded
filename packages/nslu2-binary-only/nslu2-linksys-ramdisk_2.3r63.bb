DESCRIPTION = "Linksys NSLU2 Stock Firmware Ramdisk."
PACKAGE_ARCH = "nslu2"
SECTION = "base"
PRIORITY = "required"
PR = "r1"

SRC_URI = "http://nslu.sf.net/downloads/nslu2-linksys-ramdisk-2.3r63.tar.bz2"

do_install () {
	( cd ${S} ; tar cvf - . ) | ( cd ${D} ; tar xvf - )
}

PACKAGES = "${PN}"
FILES_${PN} = "/"

python () {
	# Don't build unless we're targeting an nslu2
	if bb.data.getVar("MACHINE", d, 1) != "nslu2":
		raise bb.parse.SkipPackage("NSLU2 ramdisk only builds for the Linksys NSLU2")
}
