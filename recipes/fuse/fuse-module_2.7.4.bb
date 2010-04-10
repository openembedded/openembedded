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


SRC_URI[md5sum] = "4879f06570d2225667534c37fea04213"
SRC_URI[sha256sum] = "c8b070ece5d4e09bd06eea6c28818c718f803d93a4b85bacb9982deb8ded49e6"
