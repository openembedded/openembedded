require tangogps.inc

PR = "r1"

RDEPENDS = "frameworkd"

SRC_URI += "\
  file://0002-Get-GPS-data-via-the-gypsy-interface.patch;patch=1 \
  file://0003-Try-to-request-the-GPS-resource-from-ousaged.patch;patch=1 \
  file://0004-Update-fix-timestamp-from-gypsy.patch;patch=1 \
"
