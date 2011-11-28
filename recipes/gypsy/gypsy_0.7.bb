require gypsy.inc

PR = "${INC_PR}.0"

SRC_URI += " \
           file://docs-reference-am.patch \
           file://remove-werror.patch \
"

SRC_URI[gypsy.md5sum] = "cde52c121693014efa75d9098fd7de22"
SRC_URI[gypsy.sha256sum] = "60d9f9ada77c832899df4a164718895addc5015fa48f45fd58dc4bc8a983f205"

