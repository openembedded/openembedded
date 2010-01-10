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
