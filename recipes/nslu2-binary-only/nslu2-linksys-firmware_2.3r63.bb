SECTION = "base"
PACKAGES = ""
LICENSE = "GPL"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r3"

SRC_URI = "http://nslu.sf.net/downloads/${PN}-${PV}.tar.bz2"
S = "${WORKDIR}/${PN}-${PV}"

COMPATIBLE_MACHINE = "(nslu2|ixp4xx)"

do_compile () {
	install -d ${STAGING_LIBDIR}/nslu2-binaries
	install -m 0755 ${S}/RedBoot ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ${S}/SysConf ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ${S}/vmlinuz ${STAGING_LIBDIR}/nslu2-binaries/
	install -m 0755 ${S}/Trailer ${STAGING_LIBDIR}/nslu2-binaries/
}
