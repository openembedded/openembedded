DESCRIPTION = "Qt/Embedded terminus font"
HOMEPAGE = "http://www.is-vn.bg/hamster/jimmy-en.html"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "M&N Solutions GmbH <info@mn-solutions.de>"
LICENSE = "GPL"
PACKAGE_ARCH = "all"
PR = "r2"

SRC_URI = "http://www.mn-solutions.de/downloads/mnci/terminus-fonts.tar.bz2"
S = ${WORKDIR}/terminus-fonts

do_install() {
	mkdir -p ${D}${palmqtdir}/lib/fonts
	cp *.qpf ${D}${palmqtdir}/lib/fonts
}

inherit qpf
