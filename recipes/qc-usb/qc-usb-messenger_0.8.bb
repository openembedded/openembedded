DESCRIPTION = "Driver for QuickCam Messenger and Communicate usb cameras"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://home.mag.cx/messenger/source/${PN}-${PV}.tar.gz \
	   file://qc-messenger-0.8-fix;patch=1"

SRC_URI[md5sum] = "8163c9c6aa773dfc647a4835254706bf"
SRC_URI[sha256sum] = "d7de5a0b35f3db3a76ff515f35d0fda45cf79e9f7a24b6d9bb4cc2b254742fed"

S = "${WORKDIR}/${PN}-${PV}"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake 'KSRC=${STAGING_KERNEL_DIR}' \
        	   'KDIR=${STAGING_KERNEL_DIR}' \
                   'CC="${KERNEL_CC}"' \
                   'LD="${KERNEL_LD}"' \
		   'LINUX_DIR=${STAGING_KERNEL_DIR}' \
		   all
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc
}

