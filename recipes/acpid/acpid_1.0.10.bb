require acpid.inc

SRC_URI_append = " file://event.c.diff;apply=yes \
                   file://netlink.diff;apply=yes \
                   file://gcc44.diff;apply=yes \
                 "
PR = "${INC_PR}.0"
SRC_URI[md5sum] = "61156ef32015c56dc0f2e3317f4ae09e"
SRC_URI[sha256sum] = "22703ce0dd7305aca01bc9ac741659c32b1593f1d6fde492df7f01067a534760"
