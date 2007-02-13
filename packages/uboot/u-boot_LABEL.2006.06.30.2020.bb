require u-boot.inc

PR = "r2"

TAG = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=${TAG} \
           file://nohelloworld.patch;patch=1"
#           file://config.patch;patch=1"

SRC_URI_append_navman-icn330 = " http://www.duff.dk/navman/navman-u-boot-2006-30-2020.patch;patch=1"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#inherit base
