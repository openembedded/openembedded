SECTION = "libs"
DESCRIPTION = "The Device-mapper is a new component of the linux kernel \
that supports logical volume management. It is required by LVM2 and EVMS. \
The original LVM (included in stock 2.4 kernels) does not use it."
LICENSE = "GPL"
PR = "r4"

S = "${WORKDIR}/${PN}.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/dm/device-mapper.${PV}.tgz \
	   file://devmap-mknod-busybox.patch;patch=1 \
	   file://remove_insanity.patch;patch=1 "

inherit autotools update-rc.d

# The install-script will fail without this.
EXTRA_OECONF="--with-user= --with-group= "
TARGET_CC_ARCH += "${LDFLAGS}"


INITSCRIPT_NAME = "devmap_mknod.sh"
INITSCRIPT_PARAMS = "defaults"

do_stage () {
        install -m 0644 ${S}/lib/libdevmapper.h ${STAGING_INCDIR} || die "failed to install libdevmapper.h"
        oe_libinstall -a -so -C lib/ioctl libdevmapper ${STAGING_LIBDIR}
}

do_install() {
        autotools_do_install
#	oe_runmake install_static_lib
	install -d ${D}/${libdir}/ioctl
	install -m 755 ${S}/lib/ioctl/libdevmapper.a ${D}/${libdir}/ioctl/
        install -D -m 755 ${S}/scripts/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

SRC_URI[md5sum] = "074cf116cc2c7194f2d100bc5f743833"
SRC_URI[sha256sum] = "963cc8a1f7e73a0929b7b527f6b4cfc5f78c932d673b5c13c889108d3182811a"
