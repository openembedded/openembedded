DESCRIPTION = "inotify-tools is a set of command line utilities for the \
Linux inotify filesystem change notification system."
LICENSE = "GPL"
AUTHOR = "Rohan McGovern"
HOMEPAGE = "http://inotify-tools.sourceforge.net/"
PR = "r0"

EXTRA_OECONF = "--disable-doxygen"

SRC_URI = "${SOURCEFORGE_MIRROR}/inotify-tools/inotify-tools-3.12.tar.gz \
file://no-tests.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "a593b2eabde56f122e2bb3d2d45f7ca7"
SRC_URI[sha256sum] = "90f69ae24cc21fa6d33dc406077f16c06113b3000f7d267e7056e52f50d0abc0"
