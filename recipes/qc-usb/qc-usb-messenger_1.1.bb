DESCRIPTION = "Driver for QuickCam Messenger and Communicate usb cameras"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://home.mag.cx/messenger/source/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "47cdbf10bdff4dd111c867127ffc7928"
SRC_URI[sha256sum] = "81f67fd6a43f101f5f19d169130d182440c1aec39d1ad856be05a5f5976d782c"

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
