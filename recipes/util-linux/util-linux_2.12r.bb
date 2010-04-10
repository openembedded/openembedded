require util-linux.inc

SRC_URI += "file://util-linux_2.12r-12.diff.gz;patch=1"
SRC_URI += "file://glibc-fix.patch;patch=1"
SRC_URI += "file://glibc-umount2.patch;patch=1"
SRC_URI += "file://fdiskbsdlabel-avr32.patch;patch=1" 
SRC_URI += "file://util-linux-2.12r-cramfs-1.patch;patch=1" 

PR = "r15"

SRC_URI[md5sum] = "af9d9e03038481fbf79ea3ac33f116f9"
SRC_URI[sha256sum] = "b8e499b338ce9fbd1fb315194b26540ec823c0afc46c9e145ac7a3e38ad57e6b"
