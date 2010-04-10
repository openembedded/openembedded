DESCRIPTION = "Very high-quality data compression program"
SECTION = "console/utils"
PR = "r1"

LICENSE = "bzip2"
FILESPATH =. "${FILE_DIRNAME}/bzip2-${PV}:"
SRC_URI = "http://www.bzip.org/${PV}/bzip2-${PV}.tar.gz \
	   file://bzip2-1.0.5-autoconfiscated.patch;patch=1"

S = "${WORKDIR}/bzip2-${PV}"

inherit autotools_stage pkgconfig native

do_configure_prepend () {
	if test -f LICENSE ; then sh ./autogen.sh ; fi
}

SRC_URI[md5sum] = "3c15a0c8d1d3ee1c46a1634d00617b1a"
SRC_URI[sha256sum] = "f7bf5368309d76e5daf3a89d4d1bea688dac7780742e7a0ae1af19be9316fe22"
