DESCRIPTION = "Ink Spill is a Flood It Clone by Al Sweigart"
HOMEPAGE = "http://inventwithpython.com/blog/2010/09/09/code-comments-tutorial-ink-spill-a-flood-it-clone/"
LICENSE = "Creative Commons BY-NC-SA 3.0 US"
DEPENDS = "python-pygame"
RDEPENDS_${PN} = "python-pygame"
SRC_URI = "hg://www.jade-hamburg.de/~teythoon/repos;module=${PN};rev=${SRCREV};proto=https"
SRCREV = "d7185f0b3f28"
S = "${WORKDIR}/inkspill"

inherit distutils

FILES_${PN} += " ${datadir}/applications/* ${datadir}/pixmaps/*"
