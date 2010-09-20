DESCRIPTION = "Very high-quality data compression program"
SECTION = "console/utils"
PR = "r0"

LICENSE = "bzip2"
FILESPATHPKG =. "bzip2-${PV}:"
SRC_URI = "http://www.bzip.org/${PV}/bzip2-${PV}.tar.gz \
	   file://bzip2-1.0.5-autoconfiscated.patch"
SRC_URI[md5sum] = "00b516f4704d4a7cb50a1d97e6e8e15b"
SRC_URI[sha256sum] = "a2848f34fcd5d6cf47def00461fcb528a0484d8edef8208d6d2e2909dc61d9cd"

S = "${WORKDIR}/bzip2-${PV}"

inherit autotools pkgconfig native

do_configure_prepend () {
	if test -f LICENSE ; then sh ./autogen.sh ; fi
}
