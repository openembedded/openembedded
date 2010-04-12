require olsrd.inc
PR = "r0"

# Oddity in the 0.5.5 source tarball.
S = "${WORKDIR}/olsrd-a5b9cf969979"

SRC_URI += "file://olsrd-0.5.5-unbreak-makefile.patch;patch=1"

SRC_URI[md5sum] = "bd1cd216c318c1359ab6e832adbb1962"
SRC_URI[sha256sum] = "2fab4646166cc887a87933f52e51ce07c23f4e0395d380ee2f8557805c4884bc"
