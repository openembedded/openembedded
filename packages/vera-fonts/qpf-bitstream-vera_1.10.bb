DESCRIPTION = "The Bitstream Vera fonts - QPF Edition"
SECTION = "opie/fonts"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PRIORITY = "optional"
LICENSE = "Bitstream Vera"
PACKAGE_ARCH = "all"
PR = "r2"

PROVIDES = "qpf-bitstream-vera-small qpf-bitstream-vera-large"

SRC_URI = "http://openzaurus.org/mirror/vera-qpf_1.10-3.tar.gz"
S = "${WORKDIR}/vera-qpf"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
        for i in *.qpf; do 
                install -m 644 $i ${D}${palmqtdir}/lib/fonts/${i} 
        done 
} 

pkg_postinst () {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}


PACKAGES = "qpf-bitstream-vera-small qpf-bitstream-vera-large"

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
