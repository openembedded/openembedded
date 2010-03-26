require libxslt.inc
PR = "${INC_PR}.0"

SRC_URI += " file://pkgconfig_fix.patch;patch=1"
SRC_URI[archive.md5sum] = "d6a9a020a76a3db17848d769d6c9c8a9"
SRC_URI[archive.sha256sum] = "4e1f39ee16596fd2a83d28d6c3b065f742254f3336f93ce8ed1cae48ecbe49da"
