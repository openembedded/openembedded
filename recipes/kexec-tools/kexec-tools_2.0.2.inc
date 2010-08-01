DESCRIPTION = "Kexec is a fast reboot feature that lets you reboot to a new Linux kernel"
AUTHOR = "Eric Biederman"
HOMEPAGE = "http://www.xmission.com/~ebiederm/files/kexec/"
SECTION = "kernel/userland"
LICENSE = "GPL"
DEPENDS = "virtual/kernel zlib"

inherit autotools

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/kexec/kexec-tools-${PV}.tar.gz"

SRC_URI[md5sum] = "bc401cf3262b25ff7c9a51fc76c8ab91"
SRC_URI[sha256sum] = "549ab65c18a2229b6bf21b6875ca6bbe0e579bca08c3543ce6aaf8287a0b4188"
