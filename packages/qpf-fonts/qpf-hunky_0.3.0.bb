DESCRIPTION = "Hunky fonts - QPF Edition"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Gints Polis <gints.polis@cc.lv>"
LICENSE = "Bitstream Vera"
HOMEPAGE = "http://www.yoper.com/ariszlo/hunky.html"
PACKAGE_ARCH = "all"
PR = "r2"

SRC_URI = "http://handhelds.org/~gints/hunkyfonts-${PV}.tar.gz"
S = "${WORKDIR}/hunkyfonts-${PV}/QPF"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
        for i in *.qpf; do 
                install -m 644 $i ${D}${palmqtdir}/lib/fonts/${i} 
        done 
} 

inherit qpf
