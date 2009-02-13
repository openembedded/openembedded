DESCRIPTION = "Generic Blob [Bootloader] for the Motorola EZX platform"
SECTION = "bootloaders"
AUTHOR = "Daniel Riberio"
HOMEPAGE = "http://people.openezx.org/wyrm/gen-blob"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "virtual/bootloader"
PV = "0.1.0+${SRCREV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

inherit autotools

SRC_URI = "svn://svn.openezx.org/trunk/src/blob/;module=gen-blob;proto=http"
S = "${WORKDIR}/gen-blob"

do_deploy() {
	dd if=${WORKDIR}/gen-blob bs=1k seek=2 conv=sync of=${WORKDIR}/gen-blob-a1200

	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 gen-blob ${DEPLOY_DIR_IMAGE}/gen-blob-for-1stgen.${SRCDATE}
	install -m 0644 gen-blob-a1200 ${DEPLOY_DIR_IMAGE}/gen-blob-for-2ndgen.${SRCDATE}
}

do_install() {
	dd if=${WORKDIR}/gen-blob bs=1k seek=2 conv=sync of=${WORKDIR}/gen-blob-a1200

	install -d ${D}/${datadir}/openezx
	install -m 0644 gen-blob ${D}${datadir}/openezx/gen-blob-for-1stgen.${SRCDATE}
	install -m 0644 gen-blob-a1200 ${D}${datadir}/openezx/gen-blob-for-2ndgen.${SRCDATE}
}

addtask deploy before do_build after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${datadir}"
