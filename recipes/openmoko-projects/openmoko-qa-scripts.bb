DESCRIPTION = "Openmoko QA test scripts"
SECTION = "utils"
LICENSE = "GPL"
PV = "0.0.0+gitr${SRCREV}"

SRC_URI = "git://git.openmoko.org/git/testing_scripts;protocol=git"
S = "${WORKDIR}/git"

RDEPENDS = "\
  bluez4 \
  opkg \
  xrandr \
  task-boot \
"

do_install() {
	   install -d ${D}/usr/bin
	   install ${S}/bin/* ${D}/usr/bin/
}
