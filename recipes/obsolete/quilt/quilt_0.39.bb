RDEPENDS_${PN} += "patch diffstat bzip2 util-linux"

require quilt_${PV}.inc

inherit autotools gettext

require quilt-package.inc
