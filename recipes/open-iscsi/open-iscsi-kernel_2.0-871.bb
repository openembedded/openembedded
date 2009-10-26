DESCRIPTION = "Open-iSCSI project is a high performance, transport independent, multi-platform implementation of RFC3720."
HOMEPAGE = "http://www.open-iscsi.org/"
LICENSE = "GPL"
MACHINE_KERNEL_PR_append = "a"

SRC_URI = "http://www.open-iscsi.org/bits/open-iscsi-${PV}.tar.gz"
S = "${WORKDIR}/open-iscsi-${PV}"
TARGET_CC_ARCH += "${LDFLAGS}"

inherit module

do_compile () {
        oe_runmake 'KSRC=${STAGING_KERNEL_DIR}' LDFLAGS="" kernel
}

do_install() {
        oe_runmake 'KSRC=${STAGING_KERNEL_DIR}' LDFLAGS="" DESTDIR="${D}" install_kernel
}

