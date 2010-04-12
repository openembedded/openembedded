require fuse.inc

RRECOMMENDS = "fuse"
PR = "r0"

S = "${WORKDIR}/fuse-${PV}"
FILES_${PN} = "/dev ${base_libdir}/modules ${sysconfdir}"
EXTRA_OECONF = " --enable-kernel-module  --with-kernel=${STAGING_KERNEL_DIR}"

inherit module

do_configure() {
	cd ${S} ; oe_runconf
}

do_compile(){
	LDFLAGS=""
	cd ${S}/kernel
	oe_runmake
}

fakeroot do_install() {
	LDFLAGS=""
	install -d ${D}${sysconfdir}/udev/rules.d/
	install -m 644 util/udev.rules ${D}${sysconfdir}/udev/rules.d/
	cd ${S}/kernel
	oe_runmake install DESTDIR=${D}
}


SRC_URI[md5sum] = "f95b4a238a3df5a92e9013ecb55c2c17"
SRC_URI[sha256sum] = "e4639f9e08f0b8cc9f4a0bb8cbe47da06fa57cb310b2c5a82221e0a9ba969e9a"
