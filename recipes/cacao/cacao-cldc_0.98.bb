# Compatible with GNU Classpath 0.95 only!

require cacao-cldc.inc

PR = "r1"

SRC_URI += "\
  http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=8b8907c8b925761c9410bcadb9705346 \
	file://midpath.patch;apply=yes \
	file://offsets_make.patch;apply=yes \
	file://classpath_var.patch;apply=yes \
	file://libmath.patch;apply=yes \
	file://arm_mmap.patch;apply=yes \
	"

SRC_URI_append_arm = "file://offset.h_arm.patch;apply=yes"


SRC_URI[md5sum] = "8b8907c8b925761c9410bcadb9705346"
SRC_URI[sha256sum] = "cb9363add825cedf77764fc49a223aaf43f0a9f485b711ba8c92f16b13fff188"
