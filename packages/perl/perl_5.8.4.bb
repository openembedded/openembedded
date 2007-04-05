require perl.inc

PR = "r5"

SRC_URI += "file://uclibc.patch;patch=1 \
            file://config.sh-mipsel-linux \
            file://config.sh-i686-linux"
