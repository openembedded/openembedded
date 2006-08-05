RDEPENDS_${PN} += "patch diffstat bzip2"

require quilt.inc

inherit autotools gettext

require quilt-package.inc
