DESCRIPTION = "Driver for zd1211 family of wireless USB Dongles"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r3"
RDEPENDS = "wireless-tools"

SRC_URI = "http://zd1211.ath.cx/download/zd1211-driver-${PV}.tgz \
	file://makefile.patch;patch=1 \
	"

S = "${WORKDIR}/zd1211-driver-${PV}"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake 'MODPATH=${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net' \
		   'KERNEL_SOURCE=${STAGING_KERNEL_DIR}' \
		   'KDIR=${STAGING_KERNEL_DIR}' \
		   'KERNEL_VERSION=${KERNEL_VERSION}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
        install -m 0644 ${S}/zd1211*${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
}

SRC_URI[md5sum] = "ab79187f18b102df2fb576bd4cf733fd"
SRC_URI[sha256sum] = "8e5715e9d2bd2cb489c601ff91305f81fd662b27cb2da5486071fbab5bd8b634"
