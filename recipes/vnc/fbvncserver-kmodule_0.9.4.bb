DESCRIPTION = "Framebuffer VNC server keyboard events module"
SECTION = "kernel/modules"
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

SRC_URI[md5sum] = "01a37f17857641253541307f59dd8cc5"
SRC_URI[sha256sum] = "e22ed10ecba059904649f344be260512fdb3cbecbd95ca965f8b5cc3ea1785b5"
