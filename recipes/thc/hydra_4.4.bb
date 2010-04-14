DESCRIPTION = "A very fast network logon cracker which support many different services"
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

SRC_URI[md5sum] = "3a2e76b03f2e534119517aaa18083322"
SRC_URI[sha256sum] = "1019b3fbeb3e7e2d0c8faf81191e722bfabc714ee03ec08703faf91dab443b64"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "307e1434ae475088caa01e3b1aefbf43"
#SRC_URI[sha256sum] = "382ff75f66fc7c7ec429c4c2513c61dcb8322927a6b51542914cc7a08717caef"
