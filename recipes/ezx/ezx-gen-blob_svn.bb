DESCRIPTION = "Generic Blob [Bootloader] for the Motorola EZX platform"
SECTION = "bootloaders"
AUTHOR = "OpenEZX Team"
HOMEPAGE = "http://people.openezx.org/wyrm/gen-blob"
LICENSE = "GPL"
PROVIDES = "virtual/bootloader"
DEPENDS = "virtual/kernel"
SRCREV = "2517"
PV = "1.0.0+svnr${SRCPV}"
PE = "1"
PR = "r1"

SRC_URI = "\
  svn://svn.openezx.org/trunk/src/blob/;module=gen-blob;proto=http \
  file://remove-bogus-sed.patch;patch=1 \
"
S = "${WORKDIR}/gen-blob"

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
