SECTION = "libs"
DESCRIPTION = "The Device-mapper is a new component of the linux kernel \
that supports logical volume management. It is required by LVM2 and EVMS. \
The original LVM (included in stock 2.4 kernels) does not use it."
MAINTAINER = "Dan Williams <dan.j.williams@gmail.com>"
LICENSE = "GPL"
PR = "r2"

S = "${WORKDIR}/${PN}.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/dm/device-mapper.${PV}.tgz \
	   file://devmap-mknod-busybox.patch;patch=1"

inherit autotools update-rc.d

INITSCRIPT_NAME = "devmap_mknod.sh"
INITSCRIPT_PARAMS = "defaults"

do_stage () {
        install -m 0644 lib/libdevmapper.h ${STAGING_INCDIR} || die "failed to install libdevmapper.h"
        oe_libinstall -a -so -C lib/ioctl libdevmapper ${STAGING_LIBDIR}
}

do_install() {
        autotools_do_install
	oe_runmake install_static_lib
        install -D -m 755 ${S}/scripts/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}
