DESCRIPTION = "Unicode fonts - QPF Edition"
LICENSE = "GPL QPL"
SECTION = "opie/fonts"
PRIORITY = "optional"
PACKAGE_ARCH = "all"

SRC_URI = "http://www.openzaurus.org/mirror/qpf-unifont.tar.bz2"
S = "${WORKDIR}"

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

FILES_${PN} = "${palmqtdir}/lib/fonts"
