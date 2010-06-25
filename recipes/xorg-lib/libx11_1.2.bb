require libx11.inc
DEPENDS = "${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI += " file://dolt-fix.patch"
SRC_URI[archive.md5sum] = "c6265b59ea2b594fd68e33f9125b4d20"
SRC_URI[archive.sha256sum] = "e4863cdf5d471763806e9bcae25ea47606a56cd91a5546a34c093aa3de181051"

EXTRA_OECONF += " --without-xcb"
