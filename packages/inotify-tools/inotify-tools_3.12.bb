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

