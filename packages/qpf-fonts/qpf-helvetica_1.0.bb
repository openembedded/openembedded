DESCRIPTION = "Helvetica fonts - QPF Edition"
LICENSE = "GPL QPL"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://www.pobox.sk/~mico/zaurus.html"
PACKAGE_ARCH = "all"

SRC_URI = "http://www.hrw.one.pl/_pliki/oe/files/qpf-helvetica.tar.bz2"
S = "${WORKDIR}/helvetica"

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

PACKAGES = "qpf-helvetica-small qpf-helvetica-large"

FILES_qpf-helvetica-small = "${palmqtdir}/lib/fonts/helvetica_80* \
${palmqtdir}/lib/fonts/helvetica_100* ${palmqtdir}/lib/fonts/helvetica_120*"

FILES_qpf-helvetica-large = "${palmqtdir}/lib/fonts/helvetica_140* \
${palmqtdir}/lib/fonts/helvetica_180* ${palmqtdir}/lib/fonts/helvetica_240*"
