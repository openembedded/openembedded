DESCRIPTION = "Ink Spill is a Flood It Clone by Al Sweigart"
HOMEPAGE = "http://inventwithpython.com/blog/2010/09/09/code-comments-tutorial-ink-spill-a-flood-it-clone/"
LICENSE = "Creative Commons BY-NC-SA 3.0 US"
DEPENDS = "python-pygame"
RDEPENDS_${PN} = "python-pygame"
SRC_URI = "hg://www.jade-hamburg.de/~teythoon/repos;module=${PN};rev=${SRCREV};proto=https"
SRCREV = "897be0fe188a"
PR = "r1"
S = "${WORKDIR}/inkspill"

inherit distutils

FILES_${PN} += " ${datadir}/applications/* ${datadir}/pixmaps/*"
