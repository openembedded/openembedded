require xorg-font-common.inc

DESCRIPTION = "X font aliases."

DEPENDS = "virtual/xserver font-util"
RDEPENDS_${PN} = "encodings font-util"

PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "6d25f64796fef34b53b439c2e9efa562"
SRC_URI[archive.sha256sum] = "8b453b2aae1cfa8090009ca037037b8c5e333550651d5a158b7264ce1d472c9a"
