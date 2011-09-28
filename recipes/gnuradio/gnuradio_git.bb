require recipes/gnuradio/gnuradio.inc

PR = "${INC_PR}.3"
PV = "3.4.1-${PR}+gitr${SRCREV}"

SRCREV = "77f5aa4f1985e0605b5ed07994a2af7dac2d2a8d"

# Make it easy to test against developer repos and branches
GIT_REPO = "gnuradio.git"
GIT_BRANCH = "master"

FILESPATHPKG_prepend = "gnuradio-git:"

SRC_URI = "git://gnuradio.org/git/${GIT_REPO};branch=${GIT_BRANCH};protocol=http \
	file://0001-volk-Remove-all-traces-of-volk-from-configure-for-OE.patch \
"

S="${WORKDIR}/git"

