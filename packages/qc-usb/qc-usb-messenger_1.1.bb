DESCRIPTION = "Driver for QuickCam Messenger and Communicate usb cameras"
PRIORITY = "optional"
SECTION = "kernel/modules"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://home.mag.cx/messenger/source/${PN}-${PV}.tar.gz"

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
