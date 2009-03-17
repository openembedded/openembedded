require mathomatic.inc

SRC_URI = "http://www.panix.com/~gesslein/am.tgz"
S = "${WORKDIR}/mathomatic-12.4.2"

# source snapshot changes every day
BROKEN = "1"
