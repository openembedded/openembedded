DESCRIPTION = "Software Radio Core"
LICENSE = "GPLv3"
DEPENDS = "gsl fftwf jack"

PV = "${SRCREV}"
SRCREV = "241"

SRC_URI = "svn://206.216.146.154/svn/repos_sdr_linux/branches/ab2kt;module=dttsp-ng"
S = "${WORKDIR}/dttsp-ng/src"

inherit autotools


