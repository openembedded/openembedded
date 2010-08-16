require libx11.inc
PR = "${INC_PR}.0"

SRC_URI += " file://dolt-fix.patch"
SRC_URI[archive.md5sum] = "5d74971360f194ce33d2bd2e4d9b066c"
SRC_URI[archive.sha256sum] = "8c7f867918a3739dc7cabe955179539d4a7ecc52cb42becfd261e5dfbff511ac"
