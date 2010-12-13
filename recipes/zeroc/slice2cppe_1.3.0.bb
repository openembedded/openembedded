require icee.inc

SRC_URI="http://www.zeroc.com/download/IceE/1.3/IceE-${PV}-linux.tar.gz \
file://makefiles.patch \
file://architecture.patch \
"
SRC_URI[md5sum] = "61768fcaf4664a758e129de8689add8e"
SRC_URI[sha256sum] = "5dd6d608782fe5afce18a571f275535b3e1d70663a6d358f908ca178bf7cd356"

BBCLASSEXTEND = "native"

DEPENDS="mcpp bzip2"

do_configure () {
	:
}
