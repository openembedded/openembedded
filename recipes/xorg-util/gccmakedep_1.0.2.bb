require xorg-util-common.inc

DESCRIPTION = "create dependencies in makefiles using 'gcc -M'"
RDEPENDS_${PN} = "gcc"

PR = "r4"
PE = "1"
SRC_URI[archive.md5sum] = "fc49f45251c1336fe1dad5dba1c83fcd"
SRC_URI[archive.sha256sum] = "fdd3963294e80b27416f902a5c029c033d321f03310d3cafa3afb62b50ddce92"
