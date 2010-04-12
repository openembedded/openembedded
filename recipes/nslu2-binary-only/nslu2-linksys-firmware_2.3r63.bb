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

SRC_URI[md5sum] = "d4daf9d424a182e7ca2747d9db004581"
SRC_URI[sha256sum] = "703c9083f2f114588eb54442f7e621cbf3e0f1398c3381b5ad8d1fc56f6468a5"
