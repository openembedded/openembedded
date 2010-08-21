DESCRIPTION = "illume2 SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
RDEPENDS_${PN} = "shr-e-gadgets"
SRCREV = "4bc1a7e7a59ede2a750ee7d02729fa9c535641d9"
PV = "1.2+gitr${SRCPV}"
PR = "r5"

inherit e

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

EXTRA_OECONF = "\
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

FILES_${PN} = "${datadir}/enlightenment/data/config/illume2-shr"

RRECOMMENDS_${PN} = "\
  e-wm-sysactions-shr \
  e-wm-menu-shr \
  illume-keyboard-default-alpha \
  illume-keyboard-numeric-alt \
  illume-keyboard-default-terminal \
"

