DESCRIPTION = "iSCSI Enterprise Target is for building an iSCSI storage system on Linux"
HOMEPAGE = "http://iscsitarget.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "openssl"
RRECOMMENDS_${PN} = "kernel-module-crc32c kernel-module-libcrc32c"
PR = "r1"

# this recipe has a DEFAULT_PREFERENCE -1 for beagleboard 
# actually this probably is only needed for angstrom and minimal
# angstrom and minimal at the moment of writing use a kernel for beagleboard
# that advertises as 2.6.32 but has patches for 2.6.33 which cause
# this recipe to fail. It is not really possible to fix it in this
# recipe without breaking the recipes for other 2.6.32 kernels.
# Actually a patch for the offending kernel to make it more 2.6.32 compliant
# would be trivially simple and absolutely harmless, but the maintainer
# of that recipe was not willing to even consider a patch.
DEFAULT_PREFERENCE_beagleboard = "-1"

SRC_URI = "${SOURCEFORGE_MIRROR}/iscsitarget/iscsitarget-${PV}.tar.gz \
           file://ietd.conf \
           file://init \
           file://Makefile.patch \
           file://iscsi-target-svnr373.patch \
           file://2.6.37-compat.patch \
           "
SRC_URI[md5sum] = "2f23c0bfe124d79f5c20e34ef2aaff82"
SRC_URI[sha256sum] = "0f3c8e2c2038fbbd7059d1efdd428260013212daca75c1d56abbeec33cb8d388"

S = "${WORKDIR}/iscsitarget-${PV}"

inherit module

do_configure() {
}
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

FILES_${PN} += " ${base_sbindir}"
CFLAGS = "-isystem${STAGING_KERNEL_DIR}/include -I${STAGING_INCDIR} -L${STAGING_LIBDIR}"
LDFLAGS = "-L${STAGING_LIBDIR}"

