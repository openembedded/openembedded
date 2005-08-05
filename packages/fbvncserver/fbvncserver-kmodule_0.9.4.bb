DESCRIPTION = "Framebuffer VNC server keyboard events module"
SECTION = "kernel/module"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://sdgsystems.com/download/fbvncserver-${PV}.tar.gz \
           file://libvncs0.6.patch;patch=1 \
	   file://paths.patch;patch=1 \
	   file://kernelinclude.patch;patch=1 \
           file://ipaq.patch;patch=1"
	  
S = "${WORKDIR}/fbvncserver-${PV}"

inherit module

FBVNCSERVER_SYSTEM = "zaurus"
FBVNCSERVER_SYSTEM_h3600 = "ipaq"
FBVNCSERVER_SYSTEM_h3900 = "ipaq"

EXTRA_OEMAKE = "KERNEL_INCLUDES=-I${STAGING_KERNEL_DIR}/include ${FBVNCSERVER_SYSTEM}_kbdsim.o"

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc
	install -m 0644 ${FBVNCSERVER_SYSTEM}_kbdsim.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc/kbdsim.o
}
