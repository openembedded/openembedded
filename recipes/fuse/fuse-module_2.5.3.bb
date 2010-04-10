require fuse.inc

PR = "r0"

SRC_URI += "file://preserve_CC_with_2_4_kernel.patch;patch=1"

S = "${WORKDIR}/fuse-${PV}"

FILES_${PN} = "${base_libdir}/modules"

EXTRA_OECONF = " --enable-kernel-module  --with-kernel=${STAGING_KERNEL_DIR}"

inherit module

do_configure() {
	cd ${S}
	oe_runconf
}

do_compile(){
	LDFLAGS=""
	cd ${S}/kernel
	oe_runmake
}

fakeroot do_install() {
	LDFLAGS=""
	cd ${S}/kernel
	oe_runmake install DESTDIR=${D}
}


SRC_URI[md5sum] = "9c7e8b6606b9f158ae20b8521ba2867c"
SRC_URI[sha256sum] = "19f9e27a35e65b61c25b999c44d0c35ba858ad586379226849d097d638579057"
