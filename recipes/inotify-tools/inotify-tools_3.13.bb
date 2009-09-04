DESCRIPTION = "command line utilities for the Linux inotify filesystem change notification system."
LICENSE = "GPL"
AUTHOR = "Rohan McGovern"
HOMEPAGE = "http://inotify-tools.sourceforge.net/"

EXTRA_OECONF = "--disable-doxygen"

SRC_URI = "${SOURCEFORGE_MIRROR}/inotify-tools/inotify-tools-${PV}.tar.gz \
           file://no-tests.patch;patch=1 \
          "

inherit autotools

