DESCRIPTION = "Real-time tests, such as cyclictest."
HOMEPAGE = "http://rt.wiki.kernel.org/index.php/Cyclictest"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/people/tglx/rt-tests/rt-tests-${PV}.tar.bz2"

S = "${WORKDIR}/rt-tests"

do_install() {
	install -d ${D}${bindir}
	for binary in `find . -perm 0755 -type f`
	do
		install -m 0755 $binary ${D}${bindir}
    done
}


