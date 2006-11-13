DESCRIPTION = "APEX Boot Loader"
SECTION = ""
PRIORITY = "optional"
HOMEPAGE = "http://wiki.buici.com/twiki/bin/view/Main/ApexBootloader"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.buici.com/pub/apex/apex-${PV}.tar.gz \
	   file://defconfig"

EXTRA_OEMAKE_append = " CROSS_COMPILE=${CROSS_DIR}/bin/${HOST_PREFIX}"

oe_runmake() {
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} "$@"
	make ${PARALLEL_MAKE} LDFLAGS= CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} "$@" || die "oe_runmake failed"
}

# FIXME - make this the same as the distro kernel compilation
CMDLINE="console=ttyS0,115200 rootfstype=jffs2 root=/dev/mtdblock4 rw init=/linuxrc noirqdebug"

# Set the correct CONFIG_USER_xxx_ENDIAN and CONFIG_CMDLINE at the head
# of the .config file and remove any settings in defconfig then append
# defconfig to .config
do_configure() {
	rm -f ${S}/.config
	if test '${ARCH_BYTE_SEX}' = be
	then
	  sed -e 's/.*CONFIG_USER_BIGENDIAN.*/CONFIG_USER_BIGENDIAN=y/' \
	      -e 's/.*CONFIG_BIGENDIAN.*/CONFIG_BIGENDIAN=y/' \
	      -e 's|CONFIG_ENV_DEFAULT_CMDLINE=|CONFIG_ENV_DEFAULT_CMDLINE=\"${CMDLINE}\"|' \
		${WORKDIR}/defconfig > ${S}/.config
	else
	  sed -e 's/.*CONFIG_USER_LITTLEENDIAN.*/CONFIG_USER_LITTLEENDIAN=y/' \
	      -e 's/.*CONFIG_LITTLEENDIAN.*/CONFIG_LITTLEENDIAN=y/' \
	      -e 's/.*CONFIG_ENV_REGION_KERNEL_SWAP.*/CONFIG_ENV_REGION_KERNEL_SWAP=y/' \
	      -e 's|CONFIG_ENV_DEFAULT_CMDLINE=|CONFIG_ENV_DEFAULT_CMDLINE=\"${CMDLINE}\"|' \
		${WORKDIR}/defconfig > ${S}/.config
	fi
	oe_runmake oldconfig
}

do_populate_staging() {
	install -d ${STAGING_LOADER_DIR}
	# FIXME - arch-arm should not be hard-coded
	install -m 0755 src/arch-arm/rom/apex.bin ${STAGING_LOADER_DIR}/apex.bin
}
