require recipes/gnuradio/gnuradio.inc

PR = "${INC_PR}.4"
PV = "3.4.1-${PR}+gitr${SRCREV}"

SRCREV = "640e859f564361270d8cd30d7fbff582ad228110"

# Make it easy to test against developer repos and branches
GIT_REPO = "gnuradio.git"
GIT_BRANCH = "master"

FILESPATHPKG_prepend = "gnuradio-git:"

SRC_URI = "git://gnuradio.org/git/${GIT_REPO};branch=${GIT_BRANCH};protocol=http \
	file://0001-Remove-all-traces-of-volk-from-configure-again.patch \
        file://0001-Diable-checks-for-PyQT-and-PyQWT.patch \
        file://0001-Brute-force-selection-of-moc-and-uic.patch \
        file://0001-Disable-python-checks-so-grc-builds.patch \
"

S="${WORKDIR}/git"

