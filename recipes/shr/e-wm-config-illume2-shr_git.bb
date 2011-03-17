DESCRIPTION = "illume2 SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
RDEPENDS_${PN} = "shr-e-gadgets"
SRCREV = "b166fa3c8f7160c0102877d32ee3ad09c8afaa7d"
PV = "1.2+gitr${SRCPV}"
PR = "r8"

inherit e

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

EXTRA_OECONF = "\
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

FILES_${PN} = "${datadir}/enlightenment/data/config/illume2-shr"

ESYSACTIONS ?= "e-wm-sysactions"
EMENU ?= "e-wm-menu"

RRECOMMENDS_${PN} = "\
  ${ESYSACTIONS} \
  ${EMENU} \
  illume-keyboard-default-alpha \
  illume-keyboard-numeric-alt \
  illume-keyboard-default-terminal \
"

