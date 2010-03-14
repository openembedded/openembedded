DESCRIPTION = "Android Image Creation and Booting Utilities"
SECTION = "console/utils"
LICENSE = "GPL"
PV = "1.0+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/android/image-utils"

inherit autotools_stage native

do_deploy () {
	install -d ${DEPLOY_DIR_TOOLS}
	install -m 0755 fastboot/fastboot ${DEPLOY_DIR_TOOLS}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
