DESCRIPTION = "A Software Construction Tool"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS_virtclass-native = "python-native"
SRCNAME = "scons"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/scons/scons-${PV}.tar.gz;name=scons \
           file://toolchain-from-env.SConscript \
"
SRC_URI[scons.md5sum] = "ad6838c867abd2ad5bf371b353d594f7"
SRC_URI[scons.sha256sum] = "4bde47b9a40fe767f089f5996d56b6e85a2d4929309b9c07a2dff363a78b0002"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_append() {
	install -d ${D}${datadir}/scons/
	install -m 0644 ${WORKDIR}/toolchain-from-env.SConscript ${D}${datadir}/scons/ 
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"

RDEPENDS_${PN} = "python-shell \
	       python-stringold \
	       python-lang \
	       python-io \
	       python-fcntl \
	       python-pickle \
	       python-crypt"
