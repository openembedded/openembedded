DESCRIPTION = "Software Radio Core"
LICENSE = "GPLv3"
DEPENDS = "fftwf jack"

PV = "svnr${SRCPV}"
SRCREV = "241"
PE = "1"

SRC_URI = "svn://206.216.146.154/svn/repos_sdr_linux/branches/ab2kt;module=dttsp-ng"
S = "${WORKDIR}/dttsp-ng/src"

inherit autotools_stage


