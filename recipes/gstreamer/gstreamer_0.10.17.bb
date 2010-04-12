require gstreamer.inc

PR = "r4"

SRC_URI += "file://po-makefile-fix.patch;patch=1 \
            file://registry-do-not-look-into-debug-dirs.patch;patch=1 "


SRC_URI[archive.md5sum] = "3232416ea6fceab628236d67a7d0a44a"
SRC_URI[archive.sha256sum] = "442862dc93e734aa58f13bcf3914dc7a40d3fa28f0ae2152c80457438dc3569c"
