require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "224c36057e4416205d4e421af01a2f15"
SRC_URI[archive.sha256sum] = "b4218fd4ca5e431bf69cba848c21e91235fda30504634b9f6b6cd011dcbd8999"
