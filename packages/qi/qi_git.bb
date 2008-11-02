require qi.inc
BUILD_BRANCH = "master"
PR = "r0"

SRC_URI = "git://git.openmoko.org/git/qi.git;protocol=git;branch=${BUILD_BRANCH}"
S = "${WORKDIR}/git"

