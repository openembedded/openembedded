require recipes/gnuradio/gnuradio.inc

PR = "${INC_PR}.2"
PV = "3.4.0-${PR}+gitr${SRCREV}"

SRCREV = "62768eedf8f68680ef3a672a27025227e22ccbb0"

# Make it easy to test against developer repos and branches
GIT_REPO = "gnuradio.git"
GIT_BRANCH = "master"

FILESPATHPKG_prepend = "gnuradio-git:"

SRC_URI = "git://gnuradio.org/git/${GIT_REPO};branch=${GIT_BRANCH};protocol=http \
	file://0001-volk-Remove-all-traces-of-volk-from-configure-for-OE.patch \
"

S="${WORKDIR}/git"

