require qpf.inc

DESCRIPTION = "Bitstream Vera Monospaced Font, QPF for Qt/Embedded"
LICENSE = "Bitstream Vera"
PR = "r4"

PROVIDES += "qpf-bitstream-vera-sans-mono-small"
PROVIDES += "qpf-bitstream-vera-sans-mono-larger"
PROVIDES += "qpf-bitstream-vera-sans-mono-large"
PROVIDES += "qpf-bitstream-vera-sans-mono-huge"

SRC_URI = "http://openzaurus.org/mirror/fonts-bitstream-vera-sans-mono.tar.gz"
S = "${WORKDIR}/verasansmono"

FILES_${PN} += "${palmtopdir}"

PACKAGES = "${PN}-dbg \
qpf-bitstream-vera-sans-mono-small \
qpf-bitstream-vera-sans-mono-large \
qpf-bitstream-vera-sans-mono-larger \
qpf-bitstream-vera-sans-mono-huge ${PN}"

FILES_qpf-bitstream-vera-sans-mono-small = "\
${palmqtdir}/lib/fonts/verasansmono_10* \
	${palmqtdir}/lib/fonts/verasansmono_11* \
	${palmqtdir}/lib/fonts/verasansmono_12* \
	${palmqtdir}/lib/fonts/verasansmono_13* \
	${palmqtdir}/lib/fonts/verasansmono_14*"
FILES_qpf-bitstream-vera-sans-mono-large = "\
	${palmqtdir}/lib/fonts/verasansmono_15*" \
	${palmqtdir}/lib/fonts/verasansmono_16* \
	${palmqtdir}/lib/fonts/verasansmono_17* \
	${palmqtdir}/lib/fonts/verasansmono_18* \
	${palmqtdir}/lib/fonts/verasansmono_19*"
FILES_qpf-bitstream-vera-sans-mono-larger = "${palmqtdir}/lib/fonts/verasansmono_2*"
FILES_qpf-bitstream-vera-sans-mono-huge = "${palmqtdir}/lib/fonts/verasansmono_3*"

SRC_URI[md5sum] = "890615fa4b3e6c82cd1b9807b106f042"
SRC_URI[sha256sum] = "42c15ed555719c27f67990454cdda791cbcd26ab98712fd88ca7e20e6ce3f1fd"
