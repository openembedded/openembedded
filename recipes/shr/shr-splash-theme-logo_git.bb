DESCRIPTION = "SHR splash screen - SHR logo theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
SRCREV = "baad098dc8c8058a712a6d98a69b5558ccc54973"
PV = "0.1+gitr${SRCPV}"
PR = "r3"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

SS = "${S}"
SS_append_nokia900 = "/nokia900"
SS_append_om-gta01 = "/om-gta01"
SS_append_om-gta02 = "/om-gta02"
SS_append_htcdream = "/htcdream"
SS_append_palmpre  = "/palmpre"

ALTERNATIVE_PRIORITY = 3

require shr-splash-theme.inc

