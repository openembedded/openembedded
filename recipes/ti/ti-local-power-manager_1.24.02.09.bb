require ti-local-power-manager.inc

PV = "1_24_02_09"
PE = "1"

SRC_URI += "file://lpm-BKL-fix.patch"

SRC_URI[lpmtarball.md5sum] = "3d05453df26dfc811de04839d74c2f2b" 
SRC_URI[lpmtarball.sha256sum] = "7335959a6217df17289f81839e6c6948f31cc0797ebc5389edef7190ed3ea589"

