SRC_URI = "http://download.berlios.de/tslib/${BP}.tar.bz2 \
           file://fix_version.patch \
           file://tslib-nopressure.patch \
           file://tslib-pluginsld.patch \
           file://newer-libtool-fix.patch "
PR = "${INC_PR}.6"

include tslib.inc

SRC_URI[md5sum] = "92b2eb55b1e4ef7e2c0347069389390e"
SRC_URI[sha256sum] = "9c40d914e4f6fe00bdd77137d671c7ce4f211686228f2eb8b2d3c2360bc249c8"
