require qpf.inc

DESCRIPTION = "The Bitstream Vera fonts - QPF Edition"
LICENSE = "Bitstream Vera"
PR = "r3"

PROVIDES = "qpf-bitstream-vera-small qpf-bitstream-vera-large"

SRC_URI = "http://openzaurus.org/mirror/vera-qpf_1.10-3.tar.gz"
S = "${WORKDIR}/vera-qpf"

PACKAGES = "${PN}-dbg qpf-bitstream-vera-small qpf-bitstream-vera-large ${PN}"

FILES_qpf-bitstream-vera-small = "${palmqtdir}/lib/fonts/vera_80_50* 						\
${palmqtdir}/lib/fonts/vera_80_50i* ${palmqtdir}/lib/fonts/vera_80_75* ${palmqtdir}/lib/fonts/vera_80_75i*	\
${palmqtdir}/lib/fonts/vera_100_50* ${palmqtdir}/lib/fonts/vera_100_50i* ${palmqtdir}/lib/fonts/vera_100_75*	\
${palmqtdir}/lib/fonts/vera_100_75i* ${palmqtdir}/lib/fonts/vera_120_50* ${palmqtdir}/lib/fonts/vera_120_50i*	\
${palmqtdir}/lib/fonts/vera_120_75* ${palmqtdir}/lib/fonts/vera_120_75i*"

FILES_qpf-bitstream-vera-large = "${palmqtdir}/lib/fonts/vera_140_50* ${palmqtdir}/lib/fonts/vera_140_50i* 	\
${palmqtdir}/lib/fonts/vera_140_75*										\
${palmqtdir}/lib/fonts/vera_140_75i* ${palmqtdir}/lib/fonts/vera_160_50* ${palmqtdir}/lib/fonts/vera_160_50i*	\
${palmqtdir}/lib/fonts/vera_160_75* ${palmqtdir}/lib/fonts/vera_160_75i* ${palmqtdir}/lib/fonts/vera_180_50*	\
${palmqtdir}/lib/fonts/vera_180_50i* ${palmqtdir}/lib/fonts/vera_180_75* ${palmqtdir}/lib/fonts/vera_180_75i*"

SRC_URI[md5sum] = "13327e7086fa5ceec44550745a914f42"
SRC_URI[sha256sum] = "1ca61d438f3e5f4b7af853b48e16d68b226d568cd12eda36b94ffbf3cb9458c1"
