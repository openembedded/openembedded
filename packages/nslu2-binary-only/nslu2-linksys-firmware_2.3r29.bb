SECTION = "base"
DEPENDS = "slugimage-native unzip-native"
PACKAGES = ""
LICENSE = "GPL"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r1"

SRC_URI = "ftp://ftp.linksys.com/pub/network/NSLU2_V23R29.zip"
S = "${WORKDIR}"

python () {
	# Don't build unless we're targeting an nslu2
	if bb.data.getVar("MACHINE", d, 1) != "nslu2":
		raise bb.parse.SkipPackage("NSLU2 firmware only builds for the Linksys NSLU2")
}

do_compile () {
	slugimage -u -i NSLU2_V23R29.bin -b RedBoot -s SysConf -r ramdisk.ext2.gz -t Trailer
	install -d ${STAGING_LIBDIR}/nslu2-binaries
	install -m 0755 RedBoot ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 SysConf ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ramdisk.ext2.gz ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 Trailer ${STAGING_LIBDIR}/nslu2-binaries/
}
