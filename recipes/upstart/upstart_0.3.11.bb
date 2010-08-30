require upstart.inc

SRC_URI = "http://upstart.ubuntu.com/download/0.3/upstart-${PV}.tar.bz2;name=upstart \
    http://upstart.ubuntu.com/download/example-jobs/0.3/example-jobs-${PV}.tar.gz;name=compat \
    file://init/rcS-default file://init/rc file://init/rcS \
"

RRECOMMENDS_${PN} = "libupstart upstart-sysvcompat"

PR = "r2"

USE_VT ?= "1"
SYSVINIT_ENABLED_GETTYS ?= "1"

SRC_URI[upstart.md5sum] = "a9e475e1458c876add0441d9d4cfe9c0" 
SRC_URI[upstart.sha256sum] = "d4f7fff9112049eab318518719735d0ac66ff558ed91c2d7c7c41124de2832b6"
SRC_URI[compat.md5sum] = "22d66ef8bc9d167eb822bbfecb584107"
SRC_URI[compat.sha256sum] = "f53fae7258fcf67cb29d344e53e1548171e4781af11ff4ba92b8b81caab3c315"
