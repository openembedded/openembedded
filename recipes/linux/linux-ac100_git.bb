require linux.inc

PV = "2.6.29+${PR}+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "ac100"

SRCREV = "462ec86ebb59b2ade8e4ebb393fcb67408e3938"

SRC_URI = "\
  http://gitorious.org/ac100/kernel/archive-tarball/ac100-kernel-eclair-tosh.tar.gz \
  file://defconfig \
"

S = "${WORKDIR}/ac100-kernel"

SRC_URI[md5sum] = "2cdb73591a17b7ffd3ed207e11cf8ae2"
SRC_URI[sha256sum] = "bab7bbc1a2b859ed661131527fe17d81d93cd70421ac7724fb624a401e15c5e6"
