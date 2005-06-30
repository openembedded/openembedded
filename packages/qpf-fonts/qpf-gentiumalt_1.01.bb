DESCRIPTION = "Gentium fonts - QPF Edition"
SECTION = "opie/fonts"
PRIORITY = "optional"
LICENSE = "Gentium"
HOMEPAGE = "http://www.sil.org/~gaultney/gentium/"
PACKAGE_ARCH = "all"
PR = "r0"

SRC_URI = "http://www.hrw.one.pl/_pliki/oe/files/qpf-gentiumalt_${PV}.tar.bz2"
S = "${WORKDIR}/qpf-gentiumalt"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
        for i in *.qpf; do 
                install -m 644 $i ${D}${palmqtdir}/lib/fonts/${i} 
        done 
} 

inherit qpf
