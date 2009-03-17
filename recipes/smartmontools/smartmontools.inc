SECTION = "console/utils"
DESCRIPTION = "Control and monitor storage systems using S.M.A.R.T."
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/smartmontools/smartmontools-${PV}.tar.gz"
S = "${WORKDIR}/smartmontools-${PV}"

inherit autotools
