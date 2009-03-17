# Compatible with GNU Classpath 0.95 only!

require cacao-cldc.inc

PR = "r1"

SRC_URI += "\
  http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=8b8907c8b925761c9410bcadb9705346 \
	file://midpath.patch;patch=1 \
	file://offsets_make.patch;patch=1 \
	file://classpath_var.patch;patch=1 \
	file://libmath.patch;patch=1 \
	file://arm_mmap.patch;patch=1 \
	"

SRC_URI_append_arm = "file://offset.h_arm.patch;patch=1"

