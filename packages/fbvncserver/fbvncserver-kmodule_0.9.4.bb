DESCRIPTION = "framebuffer VNC server keyboard events module"
SECTION = "kernel"
LICENSE = "GPL"

SRC_URI = "http://sdgsystems.com/download/fbvncserver-${PV}.tar.gz \
           file://libvncs0.6.patch;patch=1 \
	   file://paths.patch;patch=1 \
	   file://kernelinclude.patch;patch=1"
	  
S = "${WORKDIR}/fbvncserver-${PV}"

inherit module

EXTRA_OEMAKE = "KERNEL_INCLUDES=-I${STAGING_KERNEL_DIR}/include zaurus_kbdsim.o"

do_install () {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc
	install -m 0644 zaurus_kbdsim.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/misc/
}
