DESCRIPTION = "xkbd i18n layouts"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"
PACKAGE_ARCH = "all"
PR = "r1"
RDEPENDS = "xkbd"

#SRC_URI = "http://whitenoise.ssrlab.com/pda/xkbd/xkbd-ru-en-123_0.1.1.tar.gz" 
SRC_URI = "file://en-ru-123.xkbd"

S = "${WORKDIR}"

do_install () { 
        install -d ${D}${prefix}/share/xkbd
        for i in *.xkbd; do 
                install -m 644 $i ${D}${prefix}/share/xkbd/${i} 
        done 
} 

FILES_${PN} = "${prefix}/share/xkbd/*.xkbd"
