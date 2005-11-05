DESCRIPTION = "Utopia fonts - QPF Edition"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL QPL"
HOMEPAGE = "http://www.pobox.sk/~mico/zaurus.html"
PACKAGE_ARCH = "all"
PR = "r1"

SRC_URI = "http://www.hrw.one.pl/_pliki/oe/files/qpf-utopia.tar.bz2"
S = "${WORKDIR}/utopia"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
        for i in *.qpf; do 
                install -m 644 $i ${D}${palmqtdir}/lib/fonts/${i} 
        done 
} 

inherit qpf
