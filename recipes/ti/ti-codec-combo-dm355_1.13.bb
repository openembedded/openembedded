require ti-codec.inc
require ti-codec-combo-dm355.inc

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/codecs/dm355_codecs_setuplinux_1_13_000.bin \
		   file://mapdmaq \
		 "

BINFILE = "dm355_codecs_setuplinux_1_13_000.bin"

S = "${WORKDIR}/dm355_codecs_1_13_000"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "113"
PR = "r15"

do_compile() {
	echo "Do nothing"
}

do_install () {
     # install mapdmaq on target
     install -d ${D}/${installdir}/codec-combo
     install -m 0755 ${WORKDIR}/mapdmaq ${D}/${installdir}/codec-combo
}

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = True

