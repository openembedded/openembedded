DESCRIPTION = "iSCSI Enterprise Target is for building an iSCSI storage system on Linux"
HOMEPAGE = "http://iscsitarget.sourceforge.net/"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/iscsitarget/iscsitarget-${PV}.tar.gz \
           file://ietd.conf \
           file://init"

SRC_URI[md5sum] = "6e5e641b832d420e030d5efb59eca7ce"
SRC_URI[sha256sum] = "994186389911d41a0d2a65b7001ff060f778e2c77f80bd98e03776b215e0732c"
S = "${WORKDIR}/iscsitarget-${PV}"


DEPENDS = "openssl"
RRECOMMENDS_${PN} = "kernel-module-crc32c kernel-module-libcrc32c"

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
