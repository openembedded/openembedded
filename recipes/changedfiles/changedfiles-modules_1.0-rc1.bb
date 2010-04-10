require changedfiles.inc

PR = "r2"
B = "${WORKDIR}/changedfiles-${PV}/module"

inherit module

do_compile() {
        ${CC} -Wall -DMODULE -D__KERNEL__ -I${STAGING_KERNEL_DIR}/include -c changedfiles.c
}

pkg_postinst() {
#!/bin/sh
if [ -n $D ]; then exit 1; fi
/bin/mknod /dev/changedfiles c 40 0; exit 0
chmod 0600 /dev/changedfiles
}

pkg_postrm() {
#!/bin/sh
if [ -n $D ]; then exit 1; fi
rm -f /dev/changedfiles
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/fs/changedfiles/
	install -m 0644 changedfiles.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/fs/changedfiles/
}

SRC_URI[md5sum] = "e44e2a833151632dae7b68e815400bc1"
SRC_URI[sha256sum] = "26991b827f96a49ebd164409852d781b0a74a765c385c56c21a7ae44d030ab42"
