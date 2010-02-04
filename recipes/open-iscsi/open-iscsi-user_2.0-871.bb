DESCRIPTION = "Open-iSCSI project is a high performance, transport independent, multi-platform implementation of RFC3720."
HOMEPAGE = "http://www.open-iscsi.org/"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://www.open-iscsi.org/bits/open-iscsi-${PV}.tar.gz"
S = "${WORKDIR}/open-iscsi-${PV}"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile () {
        oe_runmake user
}

do_install () {
        oe_runmake DESTDIR="${D}" install_user
}
