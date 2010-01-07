require ti-codec.inc
 
# Should be replaced with real http URL, but for now create codec combo tar from DVSDK installation.
SRC_URI        = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/sdk/omap_l138/1_00/latest/exports/${BINFILE};name=l138codecs"

SRC_URI[l138codecs.md5sum] = "64a53cd55bc63d3a6f4db742aff90de9"
SRC_URI[l138codecs.sha256sum] = "4fb1075ad83f6017616410eff35ada7d567f1ee1b5b23624a817e8fc7dda3f8a"

require ti-eula-unpack.inc

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "cs1omapl138_${PV}-v2_setup_linux.bin"
TI_BIN_UNPK_CMDS = "y:Y: qY:workdir"

S = "${WORKDIR}/OMAP_L138_arm_${PV}_08/cs1omapl138_${PV}"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "1_00_00"
PR = "r2"

do_compile() {
	echo "do nothing"
}

#generic codec
DSPSUFFIX_omapl138 = "x64P"

do_install () {
    install -d ${D}/${installdir}/codec-combo
	cd ${S}
	for file in `find . -name *.${DSPSUFFIX}`; do
		cp ${file} ${D}/${installdir}/codec-combo
	done
}

