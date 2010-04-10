PR = "r8"

#major version number
PVM = "4.2"

require db4.inc

#TODO SRC_URI += "file://arm-thumb-mutex.patch;patch=1"

#configuration - set in local.conf to override
DB4_CONFIG ?= " --disable-cryptography --disable-queue --disable-replication --disable-verify --enable-hash"

SRC_URI[md5sum] = "8b5cff6eb83972afdd8e0b821703c33c"
SRC_URI[sha256sum] = "f4bddd8d1b4cde0daf5e13e3493ed62a25b736b0bf258e1d929e47bc6a82a28c"
