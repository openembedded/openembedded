SECTION = "unknown"
require nasm_${PV}.bb
S = "${WORKDIR}/nasm-${PV}"
inherit native

SRC_URI[md5sum] = "9f682490c132b070d54e395cb6ee145e"
SRC_URI[sha256sum] = "87e64eff736196862ed46c04a3dffa612d765df980fa974fc65e026d811bd9d0"
