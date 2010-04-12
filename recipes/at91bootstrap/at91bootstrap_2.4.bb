require at91bootstrap.inc
SRC_URI = "ftp://www.at91.com/pub/buildroot/${PN}-${PV}.tar.bz2 \
           "
SRC_URI_append_afeb9260 = " file://0001-Generic-code-changes.patch;patch=1 \
           file://0002-Making-image-directly-flashable.patch;patch=1 \
           file://0003-AFEB9260-board-support.patch;patch=1 \
           file://0004-AFEB9260-133-board-support.patch;patch=1"

PR = "r5"

AT91BOOTSTRAP_MACHINE ?= "${MACHINE}"
AT91BOOTSTRAP_FLAGS ?= ""
AT91BOOTSTRAP_MEMORY ?= "dataflash"

AT91BOOTSTRAP_IMAGE = "at91bootstrap-${MACHINE}-${AT91BOOTSTRAP_MEMORY}-${PV}-${PR}.bin"
AT91BOOTSTRAP_SYMLINK = "at91bootstrap.bin"

PACKAGE_ARCH = "${MACHINE_ARCH}"
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} MEMORY=${AT91BOOTSTRAP_MEMORY}"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS

	rm -Rf ${S}/binaries
	oe_runmake ${AT91BOOTSTRAP_MACHINE}_defconfig
	oe_runmake AT91_CUSTOM_FLAGS="${AT91BOOTSTRAP_FLAGS}"
	chmod +x ${S}/fixboot.py
	${S}/fixboot.py ${S}/binaries/${AT91BOOTSTRAP_MACHINE}-${AT91BOOTSTRAP_MEMORY}boot-${PV}.bin
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/${AT91BOOTSTRAP_MACHINE}-${AT91BOOTSTRAP_MEMORY}boot-${PV}.bin.fixboot \
		${DEPLOY_DIR_IMAGE}/${AT91BOOTSTRAP_IMAGE}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${AT91BOOTSTRAP_IMAGE}
	cd ${DEPLOY_DIR_IMAGE}
	rm -f ${AT91BOOTSTRAP_SYMLINK}
	ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_SYMLINK}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${AT91BOOTSTRAP_SYMLINK}
}

do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile

SRC_URI[md5sum] = "10161158f116e0b171582a2f66854af1"
SRC_URI[sha256sum] = "c01e579401453ae97bd7671997d4b3d3b63e25e7e1e9cec02611a944ad1727fa"
