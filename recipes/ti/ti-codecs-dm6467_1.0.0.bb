require ti-codec.inc

PR = "r4"
CSVER = "2"
PV = "1_00_00"

SRC_URI = "http://install.source.dir.local/cs${CSVER}dm6467_${PV}.tar.gz;name=dm6467codecs"

SRC_URI[dm6467codecs.md5sum] = "43fc636eb037752169ba6ce9925a39d6"
SRC_URI[dm6467codecs.sha256sum] = "06f3efc4fbdb205884ece90ebc02c0caa536e86012b1d09c95ba4786d24681c3"

# Set the source directory
S = "${WORKDIR}/cs${CSVER}dm6467_${PV}"

# compile time dependencies
DEPENDS="ti-codec-engine ti-biosutils ti-dsplink"

do_compile() {
	make CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		 FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		 EDMA3_LLD_INSTALL_DIR=${EDMA3_LLD_INSTALL_DIR} \
		 LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		 CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		 LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
	     BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		 CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
		 XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
		 clean all

}

do_install () {
    install -d ${D}/${installdir}/codec-combo
	cd ${S}
	for file in `find . -name *.x64P`; do
		cp ${file} ${D}/${installdir}/codec-combo
	done
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
