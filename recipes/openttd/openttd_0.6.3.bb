require openttd.inc 

PR = "r0"

# When upgrading this recipe make sure to refresh this patch.
SRC_URI += "file://openttd_${PV}-buildfix.patch;patch=1"




SRC_URI[md5sum] = "d05b9ebf67c83f07e8286d0d2b1fc293"
SRC_URI[sha256sum] = "2d60e8a08768a9c81f37e699df6890c12d53f4d56b5562724c3a9ffa302c7197"
