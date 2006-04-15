DESCRIPTION = "Linksys NSLU2 Stock Firmware Samba Code Pages."
PACKAGE_ARCH = "nslu2"
SECTION = "base"
PRIORITY = "required"
PR = "r1"

SRC_URI = "http://nslu.sf.net/downloads/nslu2-linksys-ramdisk-2.3r63-2.tar.bz2"

S = "${WORKDIR}/nslu2-linksys-ramdisk-2.3r63"

do_install () {
	( cd ${S} ; mkdir unslung-tmp )
	( cd ${S}/etc ; tar cvf - samba/codepages ) | ( cd ${S}/unslung-tmp; tar xvf - )
	( cd ${S} ; rm -rf bin dev etc home lib lost+found mnt proc sbin share tmp upload usr var )
	( cd ${S} ; mv unslung-tmp etc )
	( cd ${S}/etc/samba/codepages; rm -f codepage.437 unicode_map.437 )
	( cd ${S}/etc/samba/codepages; rm -f codepage.850 unicode_map.850 )
	( cd ${S}/etc/samba/codepages; rm -f              unicode_map.ISO8859-1 )
	( cd ${S} ; tar cvf - . ) | ( cd ${D} ; tar xvf - )
}

PACKAGES = "${PN}"
FILES_${PN} = "/etc/samba/codepages"

python () {
	# Don't build unless we're targeting an nslu2
	if bb.data.getVar("MACHINE", d, 1) != "nslu2":
		raise bb.parse.SkipPackage("NSLU2 stock firmware Samba code pages only builds for the Linksys NSLU2")
}
