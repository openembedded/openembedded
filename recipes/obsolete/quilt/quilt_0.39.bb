RDEPENDS_${PN} += "patch diffstat bzip2 util-linux"

require quilt_${PV}.inc

inherit autotools gettext

require quilt-package.inc

SRC_URI[md5sum] = "34f0c654aefba0342db6c676988634b5"
SRC_URI[sha256sum] = "06b32d6f8fe7065b4c2c8142a244374e1be963757125bac20ba016b92231b5bf"