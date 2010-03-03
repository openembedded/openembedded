DESCRIPTION = "illume2 SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
SRCREV = "868999443054da51b198860459b92734a3b16d42"
PV = "1.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r8"

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

