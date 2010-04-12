require fuse.inc

RRECOMMENDS = "fuse"
PR = "r1"

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


SRC_URI[md5sum] = "66bd30503df55a87b9868835ca5a45bc"
SRC_URI[sha256sum] = "ab91922367ca4c7ae5b176823eca579b2323c463e5d8b71fe5cdfc1061860124"
