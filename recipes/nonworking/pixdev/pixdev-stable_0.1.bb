DESCRIPTION = "Pixil Operating Environment"
SECTION = "gui"
PRIORITY = "optional"
DEPENDS = "microwindows"
RDEPENDS = "microwindows"

SRC_URI = "${SOURCEFORGE_MIRROR}/pixdev/pixdev-stable-${PV}.tar.gz \
          file://${FILESDIR}/braces.patch;patch=1"
export EXTRA_OEMAKE=

inherit autotools

do_compile() {
	if [ "${MACHINE}" = "ipaq" ]; then CONFIG=defconfig_ipaq; fi
	if [ "${MACHINE}" = "collie" ]; then CONFIG=defconfig_zaurus; fi

	if [ -z "$CONFIG" ]; then CONFIG=defconfig; fi

	oe_runmake $CONFIG
	oe_runmake MWDIR=${STAGING_DIR_TARGET} "TARGET_CROSS=${TARGET_PREFIX}" all
}

do_install() {
	install -d ${D}/${prefix}/pixil

	oe_runmake "TARGET_CROSS=${TARGET_PREFIX}" INSTALL_DIR=${D}/${prefix}/pixil \
	DEST_DIR=/${prefix}/pixil install
}

SRC_URI[md5sum] = "243f23a612ced8b47e84aa2f5ddcf0a3"
SRC_URI[sha256sum] = "498214e6975be634623ce547c3fc9af20a0792c201914a5cc22e1d42ecff60cf"
