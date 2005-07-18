DEPENDS = "enigma"
DESCRIPTION = "Enigma Demo Plugin"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/enigma/enigma-demo-${PV}.tar.gz \
           file://acinclude.m4"

PV = "1.0"
PN = "enigma-demo"
PR = "r0"

PACKAGES = "enigma-demo"

S = "${WORKDIR}/enigma-demo-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "/usr/lib/tuxbox/plugins/enigma_demo.so /usr/lib/tuxbox/plugins/enigma_demo.cfg"

EXTRA_OECONF = "--with-target=native "

do_configure_prepend() {
	mkdir -p m4
	install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}
