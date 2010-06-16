DESCRIPTION = "Generic Blob [Bootloader] for the Motorola EZX platform"
SECTION = "bootloaders"
AUTHOR = "OpenEZX Team"
HOMEPAGE = "http://people.openezx.org/wyrm/gen-blob"
LICENSE = "GPL"
PROVIDES = "virtual/bootloader"
DEPENDS = "virtual/kernel"
SRCREV = "48d1cf4dbc8228b982ff40c36922769f70347da1"
PV = "1.0.0+gitr${SRCPV}"
PR = "r0"
PE = "1"

SRC_URI = "\
  git://git.openezx.org/gen-blob.git;protocol=git;branch=master \
  file://remove-bogus-sed.patch \
"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "\
  --with-board=lubbock \
  --with-cpu=pxa262 \
  --with-linux-prefix=${STAGING_KERNEL_DIR} \
  --enable-usb \
"

do_configure() {
	gnu-configize
	oe_runconf
}

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 src/blob/blob-a780  ${DEPLOY_DIR_IMAGE}/gen-blob-for-1stgen.${SRCDATE}
	install -m 0644 src/blob/blob-a1200 ${DEPLOY_DIR_IMAGE}/gen-blob-for-2ndgen.${SRCDATE}
}

addtask deploy before do_build after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"
