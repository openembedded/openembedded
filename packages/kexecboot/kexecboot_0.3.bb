LICENSE = "GPL"
PR = "r1"
DEPENDS = "klibc"
RDEPENDS = "kexec-static"
inherit autotools

# You can create your own *-img.h by doing
# ./make-image-header.sh <file>.png HAND

SRC_URI = "http://projects.linuxtogo.org/frs/download.php/221/kexecboot-${PV}.tar.gz \
	   file://rootdelay.patch;patch=1"
S = "${WORKDIR}/kexecboot-${PV}"


export CC=${TARGET_PREFIX}klcc

# standart oe cflags don't work with klcc
export CFLAGS=""
export CPPFLAGS=""
export LDFLAGS=""

