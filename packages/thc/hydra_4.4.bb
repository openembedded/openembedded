DESCRIPTION = "A very fast network logon cracker which support many different services"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SECTION = "console/network"
DEPENDS = "openssl"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://thc.org/releases/hydra-${PV}-src.tar.gz"
S = "${WORKDIR}/hydra-${PV}-src"

inherit autotools

do_configure() {
	echo "Now that's a sucky build system..."
	cp -f Makefile.am Makefile
}

BINARIES = "pw-inspector hydra"

do_install() {
	install -d ${D}${bindir}
	for f in ${BINARIES}
	do
		install -m 0755 $f ${D}${bindir}
	done
}
