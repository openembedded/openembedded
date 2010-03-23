DESCRIPTION = "Administration tool for arp packet filtering"
PRIORITY = "optional"
LICENSE = "GPL"
SECTION = "console/network"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/ebtables/arptables-v${PV}.tar.gz;name=arptables \
	file://arptables-compile-install.patch;patch=1 \
	file://arptables-init-busybox.patch;patch=1 \
	"
SRC_URI[arptables.md5sum] = "1d4ab05761f063b0751645d8f2b8f8e5"
SRC_URI[arptables.sha256sum] = "e529fd465c67d69ad335299a043516e6b38cdcd337a5ed21718413e96073f928"

S = "${WORKDIR}/arptables-v${PV}"

do_compile () {
	oe_runmake
}

fakeroot do_install () {
	oe_runmake 'BINDIR=${sbindir}' 'MANDIR=${mandir}/' 'DESTDIR=${D}' install
}
