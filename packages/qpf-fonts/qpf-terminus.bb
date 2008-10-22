require qpf.inc

DESCRIPTION = "Qt/Embedded terminus font"
HOMEPAGE = "http://www.is-vn.bg/hamster/jimmy-en.html"
LICENSE = "GPL"
PR = "r3"

#SRC_URI = "http://www.mn-solutions.de/downloads/mnci/terminus-fonts.tar.bz2" -> 404 error
SRC_URI = "http://openzaurus.linuxtogo.org/download/3.5.4/sources/terminus-fonts.tar.bz2"
S = "${WORKDIR}/terminus-fonts"
