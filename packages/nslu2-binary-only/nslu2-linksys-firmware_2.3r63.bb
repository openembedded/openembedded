SECTION = "base"
PACKAGES = ""
LICENSE = "GPL"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r1"

SRC_URI = "http://nslu.sf.net/downloads/${PN}-${PV}.tar.bz2"
S = "${WORKDIR}/${PN}-${PV}"

python () {
	# Don't build unless we're targeting an nslu2
	if bb.data.getVar("MACHINE", d, 1) != "nslu2":
		raise bb.parse.SkipPackage("NSLU2 firmware only builds for the Linksys NSLU2")
}

do_compile () {
	install -d ${STAGING_LIBDIR}/nslu2-binaries
	install -m 0755 ${S}/RedBoot ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ${S}/SysConf ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ${S}/vmlinuz ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ${S}/Trailer ${STAGING_LIBDIR}/nslu2-binaries/
}
