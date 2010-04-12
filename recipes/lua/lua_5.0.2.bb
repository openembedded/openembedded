require lua.inc

DEPENDS += "readline"
PR = "r5"
SRC_URI = "http://www.lua.org/ftp/lua-${PV}.tar.gz \
	   file://debian.patch;patch=1 \
	   file://make.patch;patch=1 \
	   file://advanced-readline.patch;patch=1"
#	   http://lua-users.org/files/wiki_insecure/power_patches/5.0/advanced-readline.patch;patch=1"
S = "${WORKDIR}/lua-${PV}"
FILESPATH = "${FILE_DIRNAME}/lua-${PV}:${FILE_DIRNAME}/lua:${FILE_DIRNAME}/files"

require lua-build.inc
inherit binconfig
NATIVE_INSTALL_WORKS = 1
BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "dea74646b7e5c621fef7174df83c34b1"
SRC_URI[sha256sum] = "a6c85d85f912e1c321723084389d63dee7660b81b8292452b190ea7190dd73bc"
