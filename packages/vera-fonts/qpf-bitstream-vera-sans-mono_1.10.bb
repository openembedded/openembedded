DESCRIPTION = "Bitstream Vera Monospaced Font, QPF for Qt/Embedded"
SECTION = "opie/fonts"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "Bitstream Vera"
PACKAGE_ARCH = "all"
PR = "r3"

PROVIDES += "qpf-bitstream-vera-sans-mono-small"
PROVIDES += "qpf-bitstream-vera-sans-mono-larger"
PROVIDES += "qpf-bitstream-vera-sans-mono-large"
PROVIDES += "qpf-bitstream-vera-sans-mono-huge"

SRC_URI = "http://openzaurus.org/mirror/fonts-bitstream-vera-sans-mono.tar.gz"
S = "${WORKDIR}/verasansmono"

FILES_${PN} += "/opt"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
	
	cd ${WORKDIR}
	files=`find . -name "*.qpf"`
        for i in $files; do 
                install -m 644 $i ${D}${palmqtdir}/lib/fonts/
        done 
} 

pkg_postinst () {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}


PACKAGES = "\
qpf-bitstream-vera-sans-mono-small \
qpf-bitstream-vera-sans-mono-large \
qpf-bitstream-vera-sans-mono-larger \
qpf-bitstream-vera-sans-mono-huge"

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
