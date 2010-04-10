require dietlibc.inc

PR = "${INC_PR}.1"

SRC_URI += "file://ccache.patch;patch=1 \
            file://ceil.patch;patch=1 \
            file://ai_addrconfig.patch;patch=1 \
           "

SRC_URI[md5sum] = "acb98d469ee932d902fdf6de07802b7c"
SRC_URI[sha256sum] = "99613d6a67f747f52e4184c613f7cba5cbb76af237c9acd04742e3ca24cf56cd"
