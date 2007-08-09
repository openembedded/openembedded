DESCRIPTION = "xkbd i18n layouts"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"
PACKAGE_ARCH = "all"
PR = "r0"
RDEPENDS = "xkbd"

SRC_URI = "http://whitenoise.ssrlab.com/pda/xkbd/xkbd-ru-en-123_0.1.1.tar.gz" 

S = "${WORKDIR}"

do_install () { 
        install -d ${D}${prefix}/share/xkbd
	cd usr/share/xkbd/
        for i in *.xkbd; do 
                install -m 644 $i ${D}${prefix}/share/xkbd/${i} 
        done 
} 

FILES_${PN} = "${prefix}/share/xkbd/*.xkbd"
