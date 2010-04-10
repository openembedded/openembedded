DESCRIPTION = "A Red-Zone memory allocator to detect unintended memory access"
HOMEPAGE = "http://duma.sourceforge.net"
LICENSE = "GPL LGPL"
SECTION = "devel"
DEPENDS = "qemu-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/duma/duma_2_5_7.tar.gz"

S = "${WORKDIR}/duma_2_5_7"

EXTRA_OECONF = "-e"

do_configure () {
	oe_runmake createconf
	qemu-${TARGET_ARCH} -L ${STAGING_DIR_HOST} ./createconf
}

do_compile () {
	oe_runmake libduma.a libduma.so.0.0
}

do_install () {
	install -d ${D}${base_bindir}
	install -d ${D}${base_libdir}
	install -d ${D}${mandir}/man3
	oe_runmake install prefix="${D}" MAN_INSTALL_DIR="${D}${mandir}/man3"
}

SRC_URI[md5sum] = "d3e981cdc2b78de652215da9b4ac399f"
SRC_URI[sha256sum] = "6d851f4117002d3523354b70c3f9be4abe5325b084ff54d01ac6daa5ce9a5944"
