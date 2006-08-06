RDEPENDS_${PN} += "patch diffstat bzip2"

require quilt_${PV}.inc

inherit autotools gettext

require quilt-package.inc
