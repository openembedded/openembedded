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

