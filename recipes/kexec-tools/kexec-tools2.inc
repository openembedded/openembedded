DESCRIPTION = "Kexec is a fast reboot feature that lets you reboot to a new Linux kernel"
AUTHOR = "Eric Biederman"
HOMEPAGE = "http://www.xmission.com/~ebiederm/files/kexec/"
SECTION = "kernel/userland"
LICENSE = "GPL"
DEPENDS = "virtual/kernel zlib"

inherit autotools


SRC_URI = "http://www.kernel.org/pub/linux/kernel/people/horms/kexec-tools/kexec-tools-${PV}.tar.gz \
           file://fix-arm-arch-detection.patch;patch=1 \
           file://no-getline-no-fscanf.patch;patch=1 \
           file://kexec-tools-2-arm-add-uImage.patch;patch=1 \
           "
