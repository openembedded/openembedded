DESCRIPTION = "command line utilities for the Linux inotify filesystem change notification system."
LICENSE = "GPL"
AUTHOR = "Rohan McGovern"
HOMEPAGE = "http://inotify-tools.sourceforge.net/"

EXTRA_OECONF = "--disable-doxygen"

SRC_URI = "${SOURCEFORGE_MIRROR}/inotify-tools/inotify-tools-${PV}.tar.gz \
           file://no-tests.patch;patch=1 \
          "

inherit autotools


SRC_URI[md5sum] = "35d7178297390f18bae451e083362acf"
SRC_URI[sha256sum] = "464146acec2c118be63a6c2a090d9252fbe9689c093db85b695d0502fa229445"
