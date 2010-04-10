SRC_URI = "ftp://ftp.trolltech.com/pub/freebies/tmake/tmake-${PV}.tar.gz"
DESCRIPTION = "tmake is an easy-to-use tool for creating and maintaining makefiles across many platforms and compilers."
LICENSE = "Unknown"
DEPENDS = ""
SECTION = "devel"
PRIORITY = "optional"

S = "${WORKDIR}/tmake-${PV}"

# Ick. This .bb file should really have a -native version doing this, even if it is a perl script... RP
do_stage() {
	install -m 0755 bin/tmake bin/progen ${STAGING_BINDIR_NATIVE}/

	install -d ${STAGING_DATADIR}/tmake
	cp -R lib/* ${STAGING_DATADIR}/tmake/
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 bin/tmake bin/progen ${D}${bindir}/

	install -d ${D}${datadir}/tmake
	cp -R lib/* ${D}${datadir}/tmake/
}

PACKAGES = "${PN}-dbg tmake"
FILES = ""
FILES_tmake="${bindir} ${datadir}/tmake"

SRC_URI[md5sum] = "b007a86a83483ff9bd6795f45780ddce"
SRC_URI[sha256sum] = "6d828029e276f42fee507f58ed0bd6890ef75f0e54f45f2b1129a2426c817c61"
