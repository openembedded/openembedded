SECTION = "base"
DEPENDS = ""
PACKAGES = ""
INHIBIT_DEFAULT_DEPS = "1"
PR = "r15"

SRC_URI = "http://nslu.sf.net/downloads/switchbox-4.7.tar.gz"
S = "${WORKDIR}"

python () {
	# Don't build switchbox firmware unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("Switchbox is only relevant for the Linksys NSLU2")
}

do_compile () {
	install -d ${STAGING_LIBDIR}/nslu2-binaries
	install -m 0755 switchbox.ext2.gz ${STAGING_LIBDIR}/nslu2-binaries/switchbox.ext2.gz
}
