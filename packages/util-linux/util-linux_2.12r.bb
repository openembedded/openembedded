require util-linux.inc

SRC_URI += "file://util-linux_2.12r-12.diff.gz;patch=1"
SRC_URI += "file://glibc-fix.patch;patch=1"
SRC_URI += "file://glibc-umount2.patch;patch=1"
SRC_URI += "file://fdiskbsdlabel-avr32.patch;patch=1" 
SRC_URI += "file://util-linux-2.12r-cramfs-1.patch;patch=1" 

PR = "r15"
