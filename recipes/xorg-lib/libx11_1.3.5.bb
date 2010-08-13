require libx11.inc
PR = "${INC_PR}.0"

SRC_URI += " file://dolt-fix.patch"
SRC_URI[archive.md5sum] = "a1175b6667fcb249c6f1d725965944e3"
SRC_URI[archive.sha256sum] = "c95a3e3b5c7d45f933f922bdf6c757640f1c370369e85130bb75a9810dc6ede6"
