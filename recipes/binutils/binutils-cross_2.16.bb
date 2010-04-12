FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "bcb9fabaf0eaf91bd38c4ee148658df8"
SRC_URI[sha256sum] = "5645c3371aac47cbbcc1354eab10ec32777837d7cb4ba47b94c9043612b12f36"
