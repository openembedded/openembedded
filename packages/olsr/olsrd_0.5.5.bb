require olsrd.inc
PR = "r0"

# Oddity in the 0.5.5 source tarball.
S = "${WORKDIR}/olsrd-a5b9cf969979"

SRC_URI += "file://olsrd-0.5.5-unbreak-makefile.patch;patch=1"
