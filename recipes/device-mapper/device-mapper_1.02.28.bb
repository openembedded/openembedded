SECTION = "libs"
DESCRIPTION = "The Device-mapper is a new component of the linux kernel \
that supports logical volume management. It is required by LVM2 and EVMS. \
The original LVM (included in stock 2.4 kernels) does not use it."
LICENSE = "GPL"

PR = "r1"

S = "${WORKDIR}/${PN}.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/dm/device-mapper.${PV}.tgz \
       file://devmap-mknod-busybox.patch \
	   file://remove_insanity.patch "

inherit autotools update-rc.d

# The install-script will fail without this.
EXTRA_OECONF="--with-user= --with-group= "

INITSCRIPT_NAME = "devmap_mknod.sh"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
	install -d ${D}/${libdir}/ioctl
	install -m 755 ${S}/lib/ioctl/libdevmapper.a ${D}/${libdir}/ioctl/
        install -D -m 755 ${S}/scripts/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

FILES_${PN}-dev += "${libdir}/ioctl/*.a"

SRC_URI[md5sum] = "c9ae0776994a419f9e1ba842164bb626"
SRC_URI[sha256sum] = "24c7887fe896325a6cdc86b8beeb0d9c2de8b1c4cb20f53c2dc8f90963fc39bf"
