PR = "r10"

# major version number
PVM = "4.3"

require db4.inc

SRC_URI += "file://arm-thumb-mutex.patch;patch=1"

#configuration - set in local.conf to override
# All the --disable-* options replace --enable-smallbuild, which breaks a bunch of stuff (eg. postfix)
DB4_CONFIG ?= "--enable-o_direct --disable-cryptography --disable-queue --disable-replication --disable-statistics --disable-verify --enable-compat185"

SRC_URI[md5sum] = "200b9f5d74175875fcb3ee54adbf0007"
SRC_URI[sha256sum] = "a1fa714482f25a67a19490303a0164326ac63bd7653ae3f4664c2536b14f3337"
