#class for all the sources under shr project

HOMEPAGE = "http://projects.openmoko.org/projects/shr/"
SHR_RELEASE ?= "shr"
SHR_MIRROR ?= "git://git.shr-project.org/repo"

LICENSE ?= "GPL"
CVS_TARBALL_STASH =""
GITREV = "r${SRCREV}"

SRC_URI = "${SHR_MIRROR}/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

FILES_${PN} += "${datadir}/icons"

