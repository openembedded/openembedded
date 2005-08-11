DEFAULT_PREFERENCE_unslung = "-1"

DESCRIPTION = "Linksys NSLU2 Stock Firmware Libraries."
PACKAGE_ARCH = "nslu2"
SECTION = "base"
PRIORITY = "required"
PR = "r0"

SRC_URI = "http://www.you-need-to-create-this-yourself.com/nslu2-linksys-ramdisk-2.3r63.tar.bz2"

S = "${WORKDIR}/nslu2-linksys-ramdisk-2.3r63"

do_install () {
	( cd ${S} ; rm -rf bin dev etc home mnt proc sbin share tmp upload usr var )
	( cd ${S} ; tar cvf - . ) | ( cd ${D} ; tar xvf - )
}

PACKAGES = "${PN}"
FILES_${PN} = "/lib"

python () {
	# Don't build unless we're targeting an nslu2
	if bb.data.getVar("MACHINE", d, 1) != "nslu2":
		raise bb.parse.SkipPackage("NSLU2 stock firmware libraries only builds for the Linksys NSLU2")
}
