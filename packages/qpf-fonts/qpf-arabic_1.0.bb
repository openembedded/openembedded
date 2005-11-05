DESCRIPTION = "Arabic fonts from Arabeyes.org"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Abdulhaq <abdulhaq@users.sourceforge.net>"
LICENSE = "GPL"
HOMEPAGE = "http://www.arabeyes.org"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/arabeyes/arabic-fonts-${PV}.tar.gz"
S = "${WORKDIR}"

do_install () { 
        install -d ${D}${palmqtdir}/lib/fonts/ 
        for i in *.qpf; do 
                install -m 644 $i ${D}${palmqtdir}/lib/fonts/${i} 
        done 
} 

inherit qpf
