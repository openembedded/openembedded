DESCRIPTION = "a C++ class library for generating and recognising sounds."
HOMEPAGE = "http://www.gnu.org/software/ccaudio/"
LICENSE = "GPL"
SECTION = "libs"
PR = "r1"

SRC_URI = "http://ftp.gnu.org/pub/gnu/ccaudio/ccaudio2-${PV}.tar.gz \
	file://01-ccaudio-fixed-point.diff;patch=1 \
	file://02-ccaudio-stereo.diff;patch=1 \
	file://03-ccaudio-dtmf-reset.diff;patch=1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libccaudio2-${PV}"

S = "${WORKDIR}/ccaudio2-${PV}"

inherit autotools

${EXTRA_OECONF}="-without-fp"

do_stage () {
	install -d ${STAGING_INCDIR}/cc++
	install -m 0644 src/audio2.h ${STAGING_INCDIR}/cc++
	install -m 0644 src/fixedPoint.H ${STAGING_INCDIR}/cc++
	oe_libinstall -C src libccaudio2 ${STAGING_LIBDIR}
}
