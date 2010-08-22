require util-linux.inc
PR = "${INC_PR}.0"

SRC_URI += "file://util-linux_2.12r-12.diff.gz"
SRC_URI += "file://glibc-fix.patch"
SRC_URI += "file://glibc-umount2.patch"
SRC_URI += "file://fdiskbsdlabel-avr32.patch" 
SRC_URI += "file://util-linux-2.12r-cramfs-1.patch" 

SRC_URI[md5sum] = "af9d9e03038481fbf79ea3ac33f116f9"
SRC_URI[sha256sum] = "b8e499b338ce9fbd1fb315194b26540ec823c0afc46c9e145ac7a3e38ad57e6b"
