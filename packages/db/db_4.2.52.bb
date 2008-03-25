PR = "r8"

#major version number
PVM = "4.2"

require db4.inc

#TODO SRC_URI += "file://arm-thumb-mutex.patch;patch=1"

#configuration - set in local.conf to override
DB4_CONFIG ?= " --disable-cryptography --disable-queue --disable-replication --disable-verify --enable-hash"
