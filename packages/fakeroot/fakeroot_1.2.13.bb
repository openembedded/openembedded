DESCRIPTION = "Gives a fake root environment"
SECTION = "base"
HOMEPAGE = "http://joostje.op.het.net/fakeroot/index.html"
LICENSE = "GPL"

SRC_URI = "http://openzaurus.org/mirror/fakeroot_${PV}.tar.gz"

inherit autotools

do_stage() {
	install -d ${STAGING_INCDIR}/fakeroot
	install -m 644 *.h ${STAGING_INCDIR}/fakeroot
	autotools_stage_all
}
