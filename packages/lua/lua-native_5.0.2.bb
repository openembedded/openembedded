include lua.inc

PR = "r2"
DEPENDS += "readline-native"
SRC_URI = "http://www.lua.org/ftp/lua-${PV}.tar.gz \
	   file://debian.patch;patch=1 \
	   file://make.patch;patch=1 \
	   file://advanced-readline.patch;patch=1"
#	   http://lua-users.org/files/wiki_insecure/power_patches/5.0/advanced-readline.patch;patch=1"
S = "${WORKDIR}/lua-${PV}"
FILESPATH = "${FILE_DIRNAME}/lua-${PV}:${FILE_DIRNAME}/lua:${FILE_DIRNAME}/files"

inherit native
include lua-build.inc

