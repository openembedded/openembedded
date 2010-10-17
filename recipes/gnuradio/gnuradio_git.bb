require recipes/gnuradio/gnuradio.inc

PR = "${INC_PR}.0"
PV = "3.3.0-${PR}+gitr${SRCREV}"

SRCREV = "068aa7f5b2591f7cc06e4495c89600101bd19b6b"

# Make it easy to test against developer repos and branches
GIT_REPO = "gnuradio.git"
GIT_BRANCH = "next"

SRC_URI = "git://gnuradio.org/git/${GIT_REPO};branch=${GIT_BRANCH};protocol=http \
"

S="${WORKDIR}/git"

