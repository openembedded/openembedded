LICENSE = "LGPL"
DESCRIPTION = "C++ bindings for libxml2"
DEPENDS = "glibmm libxml2"

inherit gnome autotools_stage

FILES_${PN}-dev += "${libdir}/libxml++-2.6/include/libxml++config.h"

SRC_URI[archive.md5sum] = "a52fc7e6e44bb5cc187672930b843f72"
SRC_URI[archive.sha256sum] = "3287545d7e40bb24451f1afac6c77d545433d7efaf01ca8a60bcf9f6eacaf80a"
