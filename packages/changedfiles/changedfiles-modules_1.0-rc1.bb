include changedfiles.inc

PR = "r1"
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
