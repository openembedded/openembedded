DESCRIPTION = "Progear support module:"
LICENSE = "GPL"
SECTION = "kernel/modules"
HOMEPAGE = "http://spe.midco.net/mschacht/LinuxOnProgear/"
AUTHOR = "Mike Schacht <mschacht at alumni dot washington dot edu>"

COMPATIBLE_MACHINE = "progear"

SRC_URI = "${SOURCEFORGE_MIRROR}/progear/${PN}-${PV}.tar.gz \
           file://paths.patch;patch=1"

inherit module

EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/progear/
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/progear/
}
