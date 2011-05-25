inherit qt4e
require python-pyside.inc

PR = "${INC_PR}.3"
SRC_URI += " \
 file://no-accessibility-support.patch \
 file://support-qws.patch \
"

SRC_URI[code.md5sum] = "62d718a81fc7e7d19919f17fff5b43a6"
SRC_URI[code.sha256sum] = "a74db2de659009364f61ec2f2751cbef0dd59410673795880ec3cc9f0f810960"
