DESCRIPTION = "illume SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
SRCREV = "285e2f0a92fc47d9a739c5a1a936124b6e6fa819"
PV = "1.2+gitr${SRCREV}"

inherit e

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

EXTRA_OECONF = "\
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

FILES_${PN} = "${datadir}/enlightenment/data/config/illume-shr"

RRECOMMENDS_${PN} = "\
  e-wm-theme-illume-shr \
  e-wm-sysactions-shr \
  e-wm-menu-shr \
  illume-keyboard-default-alpha \
  illume-keyboard-numeric-alt \
  illume-keyboard-default-terminal \
"

