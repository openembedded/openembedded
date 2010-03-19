SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPL"

DEPENDS = "glib-2.0"

SRC_URI = "http://www.freedesktop.org/software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "6811712bced796d025d1a8a0f728d941"
SRC_URI[archive.sha256sum] = "7960be4bf7aa4b4698e8ea333cfa0bbfa7a169029e85d6a8b5390f625155c9a3"

inherit autotools

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"
