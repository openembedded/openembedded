DESCRIPTION = "A very fast network logon cracker which support many different services"
HOMEPAGE = "http://thc.org/thc-hydra/"
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

SRC_URI[md5sum] = "01f5cc3adbe9d161cf8e1855cec4fa15"
SRC_URI[sha256sum] = "9a9b7092f2e48786e8f83e5bef99fd31988f87140ad9ca840583f91b3623d628"
