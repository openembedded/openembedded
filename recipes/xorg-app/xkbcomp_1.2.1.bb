require xorg-app-common.inc
DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."
DEPENDS += " libxkbfile"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "885b4d8a7c8c7afb3312d31934cb3549"
SRC_URI[archive.sha256sum] = "b7612527914402d091424a93bc16f0d4d8778b4a874171f3f3dc681c690e65eb"

BBCLASSEXTEND = "native"
