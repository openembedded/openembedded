DESCRIPTION = "User-space keyboard daemon for external keyboards"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://kopsisengineering.com/kopsis/ZkbddUsersGuide"
AUTHOR = "David J. Kessler <dkessler@kopsisengineering.com>"
#AUTHOR = "Paul Eggleton <paule@handhelds.org>" - zkbdd is based on kbdd
LICENSE = "GPLv2"
DEPENDS = "lua"
RRECOMMENDS = "kernel-modules-input"

SRC_URI = "http://kopsisengineering.com/zkbdd-src_0.2.tar.gz"

S = "${WORKDIR}/${PN}"


do_compile() {
	oe_runmake CFLAGS="${CFLAGS} -DVERSION=\\\"${PV}\\\"" LDFLAGS="${LDFLAGS} -llua -llualib"
}

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${bindir}
	install -d ${D}${datadir}/zkbdd/drivers
	install -d ${D}${datadir}/doc/zkbdd

	install -m 0644 ${S}/zkbdd.conf ${D}${sysconfdir}/
	install -m 0755 ${S}/zkbdd ${D}${bindir}/zkbdd
	install -m 0755 ${S}/README ${D}${datadir}/doc/zkbdd/
	install -m 0644 ${S}/drivers/*.lua ${D}${datadir}/zkbdd/drivers/

}
