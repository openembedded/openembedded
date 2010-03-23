require gypsy.inc

SRC_URI = "http://gypsy.freedesktop.org/gypsy-releases/gypsy-0.7.tar.gz;name=gypsy \
           file://docs-reference-am.patch;patch=1 \
           file://remove-werror.patch;patch=1 \
"

SRC_URI[gypsy.md5sum] = "cde52c121693014efa75d9098fd7de22"
SRC_URI[gypsy.sha256sum] = "60d9f9ada77c832899df4a164718895addc5015fa48f45fd58dc4bc8a983f205"

