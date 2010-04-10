require qpf.inc

DESCRIPTION = "Qt/Embedded terminus font"
HOMEPAGE = "http://www.is-vn.bg/hamster/jimmy-en.html"
LICENSE = "GPL"
PR = "r3"

#SRC_URI = "http://www.mn-solutions.de/downloads/mnci/terminus-fonts.tar.bz2" -> 404 error
SRC_URI = "http://openzaurus.linuxtogo.org/download/3.5.4/sources/terminus-fonts.tar.bz2"
S = "${WORKDIR}/terminus-fonts"

SRC_URI[md5sum] = "e7b056a7619cdd460b5db5a7e263cafc"
SRC_URI[sha256sum] = "cf7becd610e298d23780216f474907745bd29484f7f81308a9d13cf07f2a4e2d"
