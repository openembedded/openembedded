DESCRIPTION = "Helvetica fonts - QPF Edition"
LICENSE = "GPL QPL"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://www.pobox.sk/~mico/zaurus.html"
PR = "r1"

SRC_URI = "http://www.hrw.one.pl/_pliki/oe/files/qpf-helvetica.tar.bz2"
S = "${WORKDIR}/helvetica"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
        for font in *.qpf; do 
                install -m 644 $font ${D}${palmqtdir}/lib/fonts/
        done 
} 

inherit qpf
