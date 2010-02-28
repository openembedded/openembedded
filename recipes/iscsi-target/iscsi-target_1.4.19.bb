DESCRIPTION = "iSCSI Enterprise Target is for building an iSCSI storage system on Linux"
HOMEPAGE = "http://iscsitarget.sourceforge.net/"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/iscsitarget/iscsitarget-${PV}.tar.gz;name=iscsitarget1419targz \

           file://libs.patch;patch=1 \
           file://2.6.31.patch;patch=1 \
           file://2.6.32.patch;patch=1 \
           file://ietd.conf \
           file://init"
SRC_URI[iscsitarget1419targz.md5sum] = "9beca214c28949cce1716b49fec57de4"
SRC_URI[iscsitarget1419targz.sha256sum] = "a9fc5e43a2806b8aa95513b2af06d97bb9181ef5fedc906d69144d93a86e664a"
S = "${WORKDIR}/iscsitarget-${PV}"


DEPENDS = "openssl"
RRECOMMENDS = "kernel-module-crc32c kernel-module-libcrc32c"

inherit module

do_configure() {
}

CFLAGS  = "-isystem${STAGING_KERNEL_DIR}/include -I${STAGING_INCDIR} -L${STAGING_LIBDIR}"
LDFLAGS = "-L${STAGING_LIBDIR}"
FILES_${PN} += " ${base_sbindir}"

do_compile() {
	oe_runmake KSRC=${STAGING_KERNEL_DIR} CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'
}

do_install() {
	# Module
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/iscsi
	install -m 0644 kernel/iscsi_trgt.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/iscsi/iscsi_trgt.ko

	# Userspace utilities
	install -d ${D}${base_sbindir}
        install -m 0755 usr/ietd ${D}${base_sbindir}/ietd
        install -m 0755 usr/ietadm ${D}${base_sbindir}/ietadm

	# Config files, init scripts
	mkdir -p ${D}${sysconfdir}/init.d
	install -m 0755 ../init ${D}${sysconfdir}/init.d/iscsi-target
	install -m 0644 ${WORKDIR}/ietd.conf ${D}${sysconfdir}/
	install -m 0644 etc/initiators.allow ${D}${sysconfdir}/
	install -m 0644 etc/initiators.deny ${D}${sysconfdir}/
}
