PR = "r1"

# major version number
PVM = "5.0"

#configuration - set in local.conf to override
# All the --disable-* options replace --enable-smallbuild, which breaks a bunch of stuff (eg. postfix)
DB5_CONFIG ?= "--enable-o_direct --disable-cryptography --disable-queue --disable-replication --disable-statistics --disable-verify --enable-compat185"

require db5.inc

SRC_URI += "file://db5-arm-thumb-mutex.patch"

SRC_URI[md5sum] = "9a749fd2e98fe15840493ddc34cc66d8"
SRC_URI[sha256sum] = "061a31a962e992dd1eae5f1e3193241d497a18968e750707526d104b53ab3cc4"
