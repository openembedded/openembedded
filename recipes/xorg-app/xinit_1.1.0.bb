require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "9144097186c3d2454beffe8ac3b53c6e"
SRC_URI[archive.sha256sum] = "c79ec1a4d60404715a626f2832f1b62f43b9d52a1e4642b40af743ee41362590"
