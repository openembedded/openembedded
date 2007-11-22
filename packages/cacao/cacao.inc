DESCRIPTION = "cacao is a Java Virtual Machine, which uses GNU Classpath as default Java core library"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"
PR = "r1"

inherit autotools

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-0.98/cacao-${PV}.tar.bz2;md5sum=8b8907c8b925761c9410bcadb9705346"

S = "${WORKDIR}/cacao-${PV}"

EXTRA_OECONF = "--disable-debug \
		${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
	       "
