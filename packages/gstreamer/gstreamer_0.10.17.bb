require gstreamer.inc

PR = "r4"

SRC_URI += "file://po-makefile-fix.patch;patch=1 \
            file://registry-do-not-look-into-debug-dirs.patch;patch=1 "

